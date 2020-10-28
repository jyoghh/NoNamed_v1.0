package jiho.marvel01.controller;

import jiho.marvel01.service.InspectResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
    public @ResponseBody Object getTopOne(@RequestParam("iid") Integer iid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", inspectResultService.getByIid(iid));
        Object result = mp;
        return result;
    }


}
