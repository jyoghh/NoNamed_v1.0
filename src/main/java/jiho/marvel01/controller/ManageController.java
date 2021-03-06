package jiho.marvel01.controller;

import jiho.marvel01.dto.InspectResultDto;
import jiho.marvel01.dto.ManageDto;
import jiho.marvel01.service.InspectResultService;
import jiho.marvel01.service.ManageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
public class ManageController {
    private ManageService manageService;
    private InspectResultService inspectResultService;

    @RequestMapping("/m_list")
    public String m_list(Model model) {
        model.addAttribute("title","조치계획 수립");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Measure/m_list";
    }

    @RequestMapping("/m_detail")
    public String m_detail(Model model) {
        model.addAttribute("title","조치계획 등록");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Measure/m_detail";
    }

    @RequestMapping("/m_livelist")
    public String m_livelist(Model model) {
        model.addAttribute("title","조치처리");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Measure/m_livelist";
    }

    @RequestMapping("/m_live_detail")
    public String m_live_detail(Model model) {
        model.addAttribute("title","조치처리 상세");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Measure/m_live_detail";
    }

    @RequestMapping("/m_live_status")
    public String m_live_status(Model model) {
        model.addAttribute("title","조치처리 초상세");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Measure/m_live_status";
    }

    @RequestMapping("/m_ticket_list")
    public String m_ticket_list(Model model) {
        model.addAttribute("title","티켓");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Measure/m_ticket_list";
    }

    @RequestMapping("/m_ticket_detail")
    public String m_ticket_detail(Model model) {
        model.addAttribute("title","티켓상세");
        model.addAttribute("menu-expended","collapseMeasure");
        return "page/Measure/m_ticket_detail";
    }

    @PostMapping(value = "/register_measure")
    public String register(ManageDto manageDto) {
        manageService.saveManage(manageDto);
        return "redirect:/i_dashboard";
    }

    @RequestMapping(value = "/insertManage.do", method = RequestMethod.POST)
    public @ResponseBody
    Object insert(ManageDto manageDto,
                  @RequestParam("iid") Long iid,
                  @RequestParam("rid") Long rid,
                  @RequestParam("type") String type,
                  @RequestParam("stDate") Date stDate,
                  @RequestParam("exDate") Date exDate,
                  @RequestParam("comment") String comment,
                  @RequestParam("status") String status,
                  @RequestParam("aid") Long aid) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("type", type);
        list.put("comment", comment);
        list.put("status", status);

        manageService.insertManage(manageDto, list, iid, rid, stDate, exDate, aid);
        return list;
    }

    @RequestMapping(value = "/insertAutoManage.do", method = RequestMethod.POST)
    public @ResponseBody
    Object insert(ManageDto manageDto,
                  @RequestParam("iid") Long iid,
                  @RequestParam("rid") Long rid,
                  @RequestParam("type") String type,
                  @RequestParam("aid") Long aid) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("type", type);
        manageService.insertAutoManage(manageDto, list, iid, rid, aid);
        return list;
    }

    @RequestMapping(value = "/insertYManage.do", method = RequestMethod.POST)
    public @ResponseBody
    Object insertY(ManageDto manageDto,
                  @RequestParam("iid") Long iid,
                  @RequestParam("rid") Long rid,
                  @RequestParam("type") String type,
                  @RequestParam("aid") Long aid) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("type", type);
        manageService.insertYManage(manageDto, list, iid, rid, aid);
        return list;
    }

    @RequestMapping(value = "/updateManage.do", method = RequestMethod.POST)
    public @ResponseBody
    Object update(@RequestParam("mid") Long mid,
                  @RequestParam("type") String type,
                  @RequestParam("comment") String comment,
                  @RequestParam("status") String status) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("type", type);
        list.put("comment", comment);
        list.put("status", status);
        manageService.updateManage(list, mid);
        return list;
    }

    @RequestMapping("/getMeasureDatatable.do")
    public @ResponseBody Object getDatatable() {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", manageService.getManagelist());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getMeasure.do", method = RequestMethod.POST)
    public @ResponseBody Object getMeasure(@RequestParam("mid") Long mid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", manageService.getManage(mid));
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getMeasureByIid.do", method = RequestMethod.POST)
    public @ResponseBody Object getMeasureByIid(@RequestParam("iid") Long iid) {
        return manageService.getManagelistbyIid(iid);
    }

    @RequestMapping(value = "/getRAs.do", method = RequestMethod.GET)
    public @ResponseBody Object getRAs() {
        return manageService.getRAs();
    }

    @RequestMapping(value = "/getNAs.do", method = RequestMethod.GET)
    public @ResponseBody Object getNAs() {
        return manageService.getNAs();
    }

}
