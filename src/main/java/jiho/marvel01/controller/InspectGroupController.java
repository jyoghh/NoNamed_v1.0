package jiho.marvel01.controller;

import jiho.marvel01.dto.InspectGroupDto;
import jiho.marvel01.service.InspectGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@AllArgsConstructor
public class InspectGroupController {

    private InspectGroupService inspectGroupService;

    @RequestMapping("/manage_obj_group")
    public String manage_obj_group(Model model, InspectGroupDto inspectGroupDto) {
        model.addAttribute("title", "점검대상그룹 관리");
        model.addAttribute("menu-expended","collapseMeasure");
        // 빠른 디버깅을 위한 더미 insert
//        inspectGroupService.insertTestInspectGroup(inspectGroupDto);
        return "page/Manage/manage_obj_group";
    }

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
    public @ResponseBody Object getDatatable() {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectGroupService.getInspectGrouplist());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/updateInspectGroup.do", method = RequestMethod.POST)
    public @ResponseBody Object update(@RequestParam("igid") Long igid,
                                       @RequestParam("igName") String igName,
                                       @RequestParam("objects") String objects,
                                       @RequestParam("manager") String manager) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("igName", igName);
        list.put("objects", objects);
        list.put("manager", manager);
        inspectGroupService.updateInspectGroup(igid, list);
        return list;
    }

    @RequestMapping(value = "/deleteInspectGroups.do", method = RequestMethod.POST)
    public String deleteInspects(@RequestParam(value = "igid[]") List<Long> igid) {
         inspectGroupService.deleteInspectGroups(igid);
         return "redirect:/inspect_setting";
    }

    @RequestMapping(value = "/getInspectGroup.do", method = RequestMethod.POST)
    public @ResponseBody Object getInspectGroup(@RequestParam("igid") Long igid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectGroupService.getInspectGroup(igid));
        Object result = mp;
        return result;
    }

}

