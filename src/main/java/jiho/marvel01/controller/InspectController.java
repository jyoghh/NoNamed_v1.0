package jiho.marvel01.controller;

import jiho.marvel01.dto.InspectDto;
import jiho.marvel01.service.InspectService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.*;

@RestController
@AllArgsConstructor
public class InspectController {

    private InspectService inspectService;

    @RequestMapping("/i_list")
    public String i_list(Model model, InspectDto inspectDto) {
        model.addAttribute("title", "점검 상세현황");
        model.addAttribute("menu-expended","collapseInspect");
        return "page/Inspect/i_list";
    }

    @PostMapping(value = "/register_inspect")
    public String register(InspectDto inspectDto) {
        inspectService.saveInspect(inspectDto);
        return "redirect:/i_dashboard";
    }

    @RequestMapping(value = "/insertInspect.do", method = RequestMethod.POST)
    public @ResponseBody Object insert(InspectDto inspectDto,
                                       @RequestParam("cgid") Integer cgid,
                                       @RequestParam("igid") Integer igid,
                                       @RequestParam("iName") String iName,
                                       @RequestParam("i_type") String i_type,
                                       @RequestParam("idate") Date idate,
                                       @RequestParam("idateEx") Date idateEx,
                                       @RequestParam("content") String content,
                                       @RequestParam("mdate") Date mdate,
                                       @RequestParam("mdateEx") Date mdateEx) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("iName", iName);
        list.put("i_type", i_type);
        list.put("content", content);
        list.put("status", "점검대기");
        inspectService.insertInspect(inspectDto, list, cgid, igid, idate, idateEx, mdate, mdateEx);
        return list;
    }

    @RequestMapping(value = "/updateInspect.do", method = RequestMethod.POST)
    public @ResponseBody Object update(InspectDto inspectDto,
                                       @RequestParam("iid") Long iid,
                                       @RequestParam("cgid") Integer cgid,
                                       @RequestParam("igid") Integer igid,
                                       @RequestParam("iName") String iName,
                                       @RequestParam("type") String type,
                                       @RequestParam("idate") Date idate,
                                       @RequestParam("idateEx") Date idateEx,
                                       @RequestParam("content") String content,
                                       @RequestParam("mdate") Date mdate,
                                       @RequestParam("mdateEx") Date mdateEx) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("iName", iName);
        list.put("type", type);
        list.put("content", content);
        list.put("status", "점검대기");
        inspectService.updateInspect(iid, list, cgid, igid, idate, idateEx, mdate, mdateEx);
        return list;
    }

    @RequestMapping(value = "/getInspectDatatable.do", method = RequestMethod.POST)
    @ResponseBody
    public Object getInspectDatatable() {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectService.getInspectlist());
        Object result = mp;
        return 1234;
    }

    @RequestMapping("/getInspectDoneList.do")
    public @ResponseBody Object getInspectDoneList() {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectService.getInspectDoneList());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/deleteinspect.do", method = RequestMethod.POST)
    public String deleteinspect(@RequestParam("iid") Long iid) {
        inspectService.deleteInspect(iid);
        return "redirect:/inspect_setting";
    }
    @RequestMapping(value = "/updateInspectStatus.do", method = RequestMethod.POST)
    public String updateInspectStatus(@RequestParam("iid") Long iid) {
        inspectService.updateInspectStatus(iid);
        return "redirect:/inspect_setting";
    }

    @RequestMapping(value = "/deleteInspects.do", method = RequestMethod.POST)
    public String deleteInspects(@RequestParam(value = "iid[]") List<Long> iid) {
         inspectService.deleteInspects(iid);
         return "redirect:/i_list";
    }

    @RequestMapping(value = "/getInspect.do", method = RequestMethod.POST)
    public @ResponseBody Object getInspect(@RequestParam("iid") Long iid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectService.getInspect(iid));
        Object result = mp;
        return result;
    }

}

