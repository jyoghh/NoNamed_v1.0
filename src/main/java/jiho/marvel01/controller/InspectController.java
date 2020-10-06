package jiho.marvel01.controller;

import jiho.marvel01.dto.InspectDto;
import jiho.marvel01.service.InspectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;

@Controller
@AllArgsConstructor
public class InspectController {

    private InspectService inspectService;

    @PostMapping(value = "/register_inspect")
    public String register(InspectDto inspectDto) {
        inspectService.saveInspect(inspectDto);
        return "redirect:/i_dashboard";
    }

    @RequestMapping(value = "/updateInspect.do", method = RequestMethod.POST)
    public @ResponseBody Object update(InspectDto inspectDto,
                                       @RequestParam("iid") Long iid,
                                       @RequestParam("igid") Integer igid,
                                       @RequestParam("iName") String iName,
                                       @RequestParam("type") String type,
                                       @RequestParam("idate") Timestamp idate,
                                       @RequestParam("content") String content,
                                       @RequestParam("mdate") Timestamp mdate,
                                       @RequestParam("status") String status) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("iName", iName);
        list.put("type", type);
        list.put("content", content);
        list.put("status", status);
        inspectService.updateInspect(iid, list, igid, idate, mdate);
        return list;
    }


    @GetMapping("/inspect_setting")
    public String inspectList(Model model) {
        List<InspectDto> inspectList = inspectService.getInspectlist();
        model.addAttribute("InspectList",inspectList);
        return "/page/Sys_setting/inspect_setting";
    }

    @RequestMapping("/getInspectDatatable.do")
    public @ResponseBody Object getDatatable(HttpServletRequest request,
                                              HttpServletResponse response) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectService.getInspectlist());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/deleteinspect.do", method = RequestMethod.POST)
    public String deleteinspect(@RequestParam("iid") Long iid) {
        inspectService.deleteInspect(iid);
        return "redirect:/inspect_setting";
    }

    @RequestMapping(value = "/deleteInspects.do", method = RequestMethod.POST)
    public String deleteInspects(@RequestParam(value = "iid[]") List<Long> iid) {
         inspectService.deleteInspects(iid);
         return "redirect:/inspect_setting";
    }

    @RequestMapping(value = "/getInspect.do", method = RequestMethod.POST)
    public @ResponseBody Object getInspect(@RequestParam("iid") Long iid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectService.getInspect(iid));
        Object result = mp;
        return mp;
    }

}

