package jiho.marvel01.controller;

import jiho.marvel01.dto.OrgDto;
import jiho.marvel01.service.OrgService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class OrgController {

    private OrgService orgService;

    @RequestMapping(value = "/register_org")
    public String register(OrgDto orgDto) {
        orgService.save(orgDto);
        return "redirect:/org_setting";
    }

    @RequestMapping(value = "/updateOrg.do", method = RequestMethod.POST)
    public @ResponseBody Object update(OrgDto orgDto,
                                       @RequestParam("oid") Long oid,
                                        @RequestParam("codes") String codes,
                                        @RequestParam("name") String name,
                                        @RequestParam("oCode") String oCode,
                                        @RequestParam("oName") String oName,
                                        @RequestParam("oEngName") String oEngName,
                                        @RequestParam("upperName") String upperName,
                                        @RequestParam("orders") String orders,
                                       @RequestParam("status") String status,
                                       @RequestParam("topcheck") Integer topcheck) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("codes", codes);
        list.put("name", name);
        list.put("oCode", oCode);
        list.put("oName", oName);
        list.put("oEngName", oEngName);
        list.put("upperName", upperName);
        list.put("status", status);
        list.put("orders", orders);
        orgService.update(oid, list, topcheck);
        return list;
    }

//    @GetMapping("/org_setting")
//    public String orgList(Model model) {
//        List<OrgDto> orgList = orgService.getList();
//        model.addAttribute("OrgList",orgList);
//        return "page/Sys_setting/org_setting";
//    }

    @RequestMapping(value = "/getOrgDatatable.do", method = RequestMethod.POST)
    public @ResponseBody Object getDatatable() {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", orgService.getList());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/deleteOrg.do", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "oid[]") List<Long> oid) {
         orgService.delete(oid);
         return "redirect:/org_setting";
    }
    @RequestMapping(value = "/getOrg.do", method = RequestMethod.POST)
    public @ResponseBody Object getOne(@RequestParam("oid") Long oid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", orgService.getOne(oid));
        Object result = mp;
        return mp;
    }

    @RequestMapping(value = "/getTopOrg.do", method = RequestMethod.POST)
    public @ResponseBody Object getTopOne() {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", orgService.getTopOrgs(1));
        Object result = mp;
        return mp;
    }

    @RequestMapping(value = "/updateUpperCode.do", method = RequestMethod.POST)
    public @ResponseBody Object updateUpperCode(@RequestParam("upperName") String upperName) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", orgService.getUpperCode(upperName));
        Object result = mp;
        return mp;
    }

}

