package jiho.marvel01.controller;

import jiho.marvel01.dto.InspectResultDto;
import jiho.marvel01.service.ConfluenceService;
import jiho.marvel01.service.InspectResultService;
import jiho.marvel01.service.ObjectService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class InspectResultController {

    private InspectResultService inspectResultService;
    private ConfluenceService confluenceService;
    private ObjectService objectService;

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

//    @RequestMapping(value = "/getTotalResultList.do", method = RequestMethod.POST)
//    public @ResponseBody Object getTotalList(@RequestParam("iid") Integer iid) {
//        Map<String, Object> mp = new HashMap<String, Object>();
//        mp.put("data", inspectResultService.getByIid(iid));
//        Object result = mp;
//
//        return result;
//    }

    @RequestMapping(value = "/getTotalResultList.do", method = RequestMethod.POST)
    public @ResponseBody Object getTotalResultList(@RequestParam("iid") Integer iid) {
        return inspectResultService.getTotalResults(iid);
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
        inspectResultService.insertInspectResult(inspectResultDto, list, iid, oid, cid);
        return list;
    }


}
