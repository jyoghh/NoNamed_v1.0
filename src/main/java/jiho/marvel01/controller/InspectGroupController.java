package jiho.marvel01.controller;

import jiho.marvel01.dto.InspectGroupDto;
import jiho.marvel01.service.InspectGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.*;

@Controller
@AllArgsConstructor
public class InspectGroupController {

    private InspectGroupService inspectGroupService;

    @RequestMapping(value = "/insertInspectGroup.do", method = RequestMethod.POST)
    public @ResponseBody Object insert(InspectGroupDto inspectGroupDto,
                                       @RequestParam("iid") Long iid,
                                       @RequestParam("igName") String igName,
                                       @RequestParam("objects") String objects,
                                       @RequestParam("manager") String manager) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("igName", igName);
        list.put("objects", objects);
        list.put("manager", manager);
        inspectGroupService.insertInspectGroup(inspectGroupDto, list, iid);
        return list;
    }

    @RequestMapping("/getInspectGroupDatatable.do")
    public @ResponseBody Object getDatatable(HttpServletRequest request,
                                              HttpServletResponse response) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectGroupService.getInspectGrouplist());
        Object result = mp;
        return result;
    }
//
//    @RequestMapping(value = "/updateInspect.do", method = RequestMethod.POST)
//    public @ResponseBody Object update(InspectGroupDto inspectGroupDto,
//                                       @RequestParam("iid") Long iid,
//                                       @RequestParam("igid") Integer igid,
//                                       @RequestParam("iName") String iName,
//                                       @RequestParam("type") String type,
//                                       @RequestParam("objects") String objects,
//                                       @RequestParam("idate") Date idate,
//                                       @RequestParam("idateEx") Date idateEx,
//                                       @RequestParam("content") String content,
//                                       @RequestParam("mdate") Date mdate,
//                                       @RequestParam("mdateEx") Date mdateEx) {
//        Map<String, String> list = new HashMap<String, String>();
//        list.put("iName", iName);
//        list.put("type", type);
//        list.put("objects", objects);
//        list.put("content", content);
//        list.put("status", "점검대기");
//        inspectGroupService.updateInspect(iid, list, igid, idate, idateEx, mdate, mdateEx);
//        return list;
//    }
//
//
//    @GetMapping("/inspect_setting")
//    public String inspectList(Model model) {
//        List<InspectGroupDto> inspectList = inspectGroupService.getInspectlist();
//        model.addAttribute("InspectList",inspectList);
//        return "/page/Sys_setting/inspect_setting";
//    }
//
//
//    @RequestMapping(value = "/deleteinspect.do", method = RequestMethod.POST)
//    public String deleteinspect(@RequestParam("iid") Long iid) {
//        inspectGroupService.deleteInspect(iid);
//        return "redirect:/inspect_setting";
//    }
//
//    @RequestMapping(value = "/deleteInspects.do", method = RequestMethod.POST)
//    public String deleteInspects(@RequestParam(value = "iid[]") List<Long> iid) {
//         inspectGroupService.deleteInspects(iid);
//         return "redirect:/inspect_setting";
//    }
//
//    @RequestMapping(value = "/getInspect.do", method = RequestMethod.POST)
//    public @ResponseBody Object getInspect(@RequestParam("iid") Long iid) {
//        Map<String, Object> mp = new HashMap<String, Object>();
//        mp.put("data", inspectGroupService.getInspect(iid));
//        Object result = mp;
//        return mp;
//    }

}

