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

    @PostMapping(value = "/register_org")
    public String register(OrgDto orgDto) {
        orgService.save(orgDto);
        return "redirect:/org_setting";
    }

    @RequestMapping(value = "/updateOrg.do", method = RequestMethod.POST)
    public @ResponseBody Object update(OrgDto orgDto,
                                       @RequestParam("oid") Long oid,
                                        @RequestParam("codes") String codes,
                                        @RequestParam("name") String name,
                                        @RequestParam("eng_name") String eng_name,
                                        @RequestParam("upper_codes") String upper_codes,
                                        @RequestParam("upper_name") String upper_name,
                                        @RequestParam("order") String order,
                                       @RequestParam("status") String status,
                                       @RequestParam("top_check") Integer top_check) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("codes", codes);
        list.put("name", name);
        list.put("eng_name", eng_name);
        list.put("upper_codes", upper_codes);
        list.put("upper_name", upper_name);
        list.put("status", status);
        list.put("order", order);

        orgService.update(oid, list, top_check);
        return list;
    }


    @GetMapping("/org_setting")
    public String orgList(Model model) {
        List<OrgDto> orgList = orgService.getList();
        model.addAttribute("OrgList",orgList);
        return "/page/Sys_setting/org_setting";
    }

    @RequestMapping("/getOrgDatatable.do")
    public @ResponseBody Object getDatatable(HttpServletRequest request,
                                              HttpServletResponse response) {
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

}

