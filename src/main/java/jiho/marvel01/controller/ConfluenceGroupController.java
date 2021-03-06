package jiho.marvel01.controller;

import jiho.marvel01.dto.ConfluenceGroupDto;
import jiho.marvel01.service.ConfluenceGroupService;
import jiho.marvel01.service.ConfluenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@AllArgsConstructor
public class ConfluenceGroupController {

    private ConfluenceGroupService confluenceGroupService;

    @RequestMapping("/manage_conf_group")
    public String manage_conf_group(Model model, ConfluenceGroupDto confluenceGroupDto) {
        model.addAttribute("title", "점검항목그룹 관리");
        model.addAttribute("menu-expended","collapseMeasure");
        // 빠른 디버깅을 위한 더미 insert
//        confluenceGroupService.insertTestConfluenceGroup(confluenceGroupDto);
        return "page/Manage/manage_conf_group";
    }

    @RequestMapping(value = "/insertConfluenceGroup.do", method = RequestMethod.POST)
    public @ResponseBody Object insert(ConfluenceGroupDto confluenceGroupDto,
                                       @RequestParam("cgName") String cgName,
                                       @RequestParam("confs") String confs) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("cgName", cgName);
        list.put("confs", confs);
        confluenceGroupService.insertConfluenceGroup(confluenceGroupDto, list);
        return list;
    }

    @RequestMapping("/getConfluenceGroupDatatable.do")
    public @ResponseBody Object getDatatable(HttpServletRequest request,
                                              HttpServletResponse response) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", confluenceGroupService.getConfluenceGrouplist());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/updateConfluenceGroup.do", method = RequestMethod.POST)
    public @ResponseBody Object update(@RequestParam("cgid") Long cgid,
                                       @RequestParam("cgName") String cgName,
                                       @RequestParam("confs") String confs) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("cgName", cgName);
        list.put("confs", confs);
        confluenceGroupService.updateConfluenceGroup(cgid, list);
        return list;
    }

    @RequestMapping(value = "/deleteConfluenceGroups.do", method = RequestMethod.POST)
    public String deleteConfluences(@RequestParam(value = "cgid[]") List<Long> cgid) {
         confluenceGroupService.deleteConfluenceGroups(cgid);
         return "redirect:/manage_conf_group";
    }

    @RequestMapping(value = "/getConfluenceGroup.do", method = RequestMethod.POST)
    public @ResponseBody Object getConfluence(@RequestParam("cgid") Long cgid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", confluenceGroupService.getConfluenceGroup(cgid));
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getConfluenceGroupBycgName.do", method = RequestMethod.POST)
    public @ResponseBody Object getConfluence(@RequestParam("cgName") String cgName) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", confluenceGroupService.getConfluenceGroupsBycgname(cgName));
        Object result = mp;
        return result;
    }

//    @RequestMapping(value = "/getConfs.do", method = RequestMethod.POST)
//    public @ResponseBody Object getConfs(@RequestParam("cid") String cid) {
//        String str = cid;
//        List<Long> list = new ArrayList<Long>();
//        for (String s : str.split(", "))
//            list.add(Long.parseLong(s));
//        Map<String, Object> mp = new HashMap<String, Object>();
//        mp.put("data", confluenceService.getConflistbyId(list));
//        Object result = mp;
//        return mp;
//    }

}

