package jiho.marvel01.model;

import jiho.marvel01.dto.InspectResultDto;
import jiho.marvel01.dto.ObjectDto;
import jiho.marvel01.service.InspectResultService;
import jiho.marvel01.service.ObjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageRouter {

    private InspectResultService inspectResultService;


     @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "마블시스템 | 취약점 진단관리 통합 포털");
        return "page/home";
    }
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "마블시스템 | 취약점 진단관리 통합 포털");
        return "page/home";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "마블시스템 | 취약점 진단관리 통합 포털");
        return "page/login";
    }
    @RequestMapping("/loginDone")
    public String loginDone(Model model) {
        model.addAttribute("title", "마블시스템 | 취약점 진단관리 통합 포털");
        return "page/loginDone";
    }
    @RequestMapping("/login_result")
    public String login_result(Model model) {
        model.addAttribute("title", "마블시스템 | 취약점 진단관리 통합 포털");
        return "page/home";
    }
    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("title", "마블시스템 | 취약점 진단관리 통합 포털");
        return "page/register";
    }
    @RequestMapping("/i_dashboard")
    public String i_dashboard(Model model) {
        model.addAttribute("title", "마블시스템 | 점검계획 현황");
        model.addAttribute("menu-expended","collapseInspect");
        return "page/Inspect/i_dashboard";
    }

    @RequestMapping("/i_register")
    public String i_register(Model model) {
        model.addAttribute("title", "마블시스템 | 점검계획 등록");
        model.addAttribute("menu-expended","collapseInspect");
        return "page/Inspect/i_register";
    }
    @RequestMapping("/done_list")
    public String done_list(Model model) {
        model.addAttribute("title", "마블시스템 | 점검계획 등록");
        model.addAttribute("menu-expended","collapseInspect");
        return "page/Inspect/done_list";
    }
    @RequestMapping("/i_donelist_report")
    public String i_donelist_report(Model model) {
        model.addAttribute("title", "마블시스템 | 점검완료 현황");
        model.addAttribute("menu-expended","collapseInspect");
        return "page/Inspect/i_donelist_report";
    }
    @RequestMapping("/i_donelist_report_detail")
    public String i_donelist_report_detail(Model model) {
        model.addAttribute("title", "마블시스템 | 점검완료 현황 상세");
        model.addAttribute("menu-expended","collapseInspect");
        return "page/Inspect/i_donelist_report_detail";
    }


    @RequestMapping("/manage_obj_group_detail")
    public String manage_obj_group_detail(Model model) {
        model.addAttribute("title", "마블시스템 | 점검대상그룹 상세");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Manage/manage_obj_group_detail";
    }

    @RequestMapping("/manage_conf_group_detail")
    public String manage_conf_group_detail(Model model) {
        model.addAttribute("title", "마블시스템 | 점검대상그룹 상세");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Manage/manage_conf_group_detail";
    }

    @RequestMapping("/report_list")
    public String report_list(Model model) {
        model.addAttribute("title","마블시스템 | 보고서");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Report/report_list";
    }
    @RequestMapping("/level_setting")
    public String level_setting(Model model) {
        model.addAttribute("title","마블시스템 | 사용자 관리");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Setting/level_setting";
    }
    @RequestMapping("/log")
    public String log(Model model) {
        model.addAttribute("title","마블시스템 | 사용자 관리");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Setting/log";
    }
    @RequestMapping("/user_setting")
    public String user_setting(Model model) {
         model.addAttribute("title","마블시스템 | 사용자 관리");
         model.addAttribute("menu-expended","collapseMeasure");
         return "page/Sys_setting/user_setting";
    }
    @RequestMapping("/org_setting")
    public String org_setting(Model model) {
        model.addAttribute("title","마블시스템 | 사용자 관리");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Sys_setting/org_setting";
    }

}
