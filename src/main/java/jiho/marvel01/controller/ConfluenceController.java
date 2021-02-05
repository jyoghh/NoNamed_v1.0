package jiho.marvel01.controller;

import jiho.marvel01.dto.ConfluenceDto;
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
public class ConfluenceController {

    private ConfluenceService confluenceService;

    @RequestMapping("/manage_conf")
    public String manage_conf(Model model, ConfluenceDto confluenceDto) {
        model.addAttribute("title","점검항목");
        model.addAttribute("menu-expended","collapseMeasure");
        // 빠른 디버깅을 위한 더미 insert
//        confluenceService.insertTestConf(confluenceDto);
        return "page/Manage/manage_conf";
    }

    @PostMapping(value = "/register_conf")
    public String register(ConfluenceDto confluenceDto) {
        confluenceService.saveConf(confluenceDto);
        return "redirect:/manage_conf";
    }

    @RequestMapping(value = "/updateConf.do", method = RequestMethod.POST)
    public @ResponseBody Object update(@RequestParam("cid") Long cid,
                                       @RequestParam("type") String type,
                                       @RequestParam("cname") String cname,
                                       @RequestParam("confCategory") String confCategory,
                                       @RequestParam("risk") String risk,
                                       @RequestParam("content") String content,
                                       @RequestParam("comply") String comply,
                                       @RequestParam("demand") String demand,
                                       @RequestParam("manual") String manual) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("type", type);
        list.put("cname", cname);
        list.put("confCategory", confCategory);
        list.put("risk", risk);
        list.put("content", content);
        list.put("comply", comply);
        list.put("demand", demand);
        list.put("manual", manual);
        confluenceService.updateConf(cid, list);
        return list;
    }

//    @GetMapping("/manage_conf")
//    public String confList(Model model) {
//        List<ConfluenceDto> confList = confluenceService.getConfList();
//        model.addAttribute("ObjectList",confList);
//        return "/page/Manage/manage_conf";
//    }

    @RequestMapping("/getConfDatatable.do")
    public @ResponseBody Object getDatatable(HttpServletRequest request,
                                              HttpServletResponse response) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", confluenceService.getConfList());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/deleteConf.do", method = RequestMethod.POST)
    public String deleteConf(@RequestParam("cid") Long cid) {
        confluenceService.deleteConf(cid);
        return "redirect:/manage_conf";
    }

    @RequestMapping(value = "/deleteConfs.do", method = RequestMethod.POST)
    public String deleteConfs(@RequestParam(value = "cid[]") List<Long> cid) {
         confluenceService.deleteConfs(cid);
         return "redirect:/manage_conf";
    }

    @RequestMapping(value = "/getConf.do", method = RequestMethod.POST)
    public @ResponseBody Object getConf(@RequestParam("cid") Long cid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", confluenceService.getConf(cid));
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getConfs.do", method = RequestMethod.POST)
    public @ResponseBody Object getConfs(@RequestParam("cid") String cid) {
        String str = cid;
        List<Long> list = new ArrayList<Long>();
        for (String s : str.split(", "))
            list.add(Long.parseLong(s));
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", confluenceService.getConflistbyId(list));
        Object result = mp;
        return result;
    }



}

