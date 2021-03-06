package jiho.marvel01.controller;

import jiho.marvel01.dto.InspectResultDto;
import jiho.marvel01.service.InspectResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class InspectResultController {

    private InspectResultService inspectResultService;

    @RequestMapping("/getInspectResultDatatable.do")
    public @ResponseBody Object getDatatable() {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectResultService.getInspectResultlist());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getListbyIid.do", method = RequestMethod.POST)
    public @ResponseBody Object getOnebyIid(@RequestParam("iid") Integer iid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectResultService.getByIid(iid));
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getListbyIidCidOid.do", method = RequestMethod.POST)
    public @ResponseBody Object getOnebyIidCidOid(@RequestParam("iid") Integer iid,
                                          @RequestParam("cid") Integer cid,
                                          @RequestParam("oid") Integer oid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectResultService.getByIidCidOid(iid, cid, oid));
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getTotalResultList.do", method = RequestMethod.POST)
    public @ResponseBody Object getTotalResultList(@RequestParam("iid") Integer iid) {
        return inspectResultService.getTotalResults(iid);
    }

    @RequestMapping(value = "/getTotalResultListByRid.do", method = RequestMethod.POST)
    public @ResponseBody Object getTotalResultListByRid(@RequestParam("rid") Integer rid) {
        return inspectResultService.getTotalResultsByRid(rid);
    }

    @RequestMapping(value = "/getTotalDoneResultList.do", method = RequestMethod.POST)
    public @ResponseBody Object getTotalDoneResultList(@RequestParam("iid") Integer iid) {
        return inspectResultService.getTotalDoneResults(iid);
    }

    @RequestMapping(value = "/getTotalDoneResultListBycat.do", method = RequestMethod.POST)
    public @ResponseBody Object getTotalDoneResultListBycat(@RequestParam("type") String type) {
        return inspectResultService.getDoneResultsbyCat(type);
    }

    @RequestMapping(value = "/getTotalResultListBycat.do", method = RequestMethod.GET)
    public @ResponseBody Object getDoneResultsbyCat(@RequestParam("type") String type) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("TotalResult", inspectResultService.getResultsbyCat(type));
        mp.put("DoneResult", inspectResultService.getDoneResultsbyCat(type));
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getTotalNoneResultListBycat.do", method = RequestMethod.GET)
    public @ResponseBody List<Integer> getTotalNoneResultListBycat() {
        String[] objTypes = {"OS","DBMS","WEB","Network","SH","SM","privacy","backup","WAS"};
        List<Integer> resArr = new ArrayList<Integer>();
        for(int i = 0; i < objTypes.length; i ++) {
            resArr.add(inspectResultService.getNoneResultsbyCat(objTypes[i]).size());
        }
        return resArr;

    }

     @RequestMapping(value = "/getInspectProgress.do", method = RequestMethod.POST)
    public @ResponseBody Object getInspectProgress(@RequestParam("iid") Integer iid) {
        return inspectResultService.getInspectProgress(iid);
    }

    @RequestMapping(value = "/insertInspectResult.do", method = RequestMethod.POST)
    public @ResponseBody Object insert(InspectResultDto inspectResultDto,
                                       @RequestParam("iid") Integer iid,
                                       @RequestParam("oid") Integer oid,
                                       @RequestParam("cid") Integer cid,
                                       @RequestParam("result") String result,
                                       @RequestParam("status") String status) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("result", result);
        list.put("status", status);
        Integer rid = inspectResultService.insertInspectResult(inspectResultDto, list, iid, oid, cid);
        String stringRid = "";
        stringRid = String.valueOf(rid);
        list.put("rid",stringRid);
        return list;
    }

    @RequestMapping(value = "/closeResult.do", method = RequestMethod.POST)
    public @ResponseBody
    Object update(@RequestParam("rid") Integer rid) {
        inspectResultService.closeResult(rid);
        return "redirect:/";
    }

    @RequestMapping(value = "/getInspectResult.do", method = RequestMethod.POST)
    public @ResponseBody Object getInspectResult(@RequestParam("rid") Integer rid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectResultService.getInspectResult(rid));
        Object result = mp;
        return result;
    }



}
