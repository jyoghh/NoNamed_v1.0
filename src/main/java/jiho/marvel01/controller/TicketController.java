package jiho.marvel01.controller;

import jiho.marvel01.dto.TicketDto;
import jiho.marvel01.service.TicketService;
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
public class TicketController {

    private TicketService ticketService;

    @RequestMapping(value = "/insertTicket.do", method = RequestMethod.POST)
    public @ResponseBody
    Object insertTicket(TicketDto ticketDto,
                  @RequestParam("oid") Integer rid,
                  @RequestParam("iid") Integer iid,
                  @RequestParam("oid") Integer oid,
                  @RequestParam("cid") Integer cid) {
        ticketService.insertTicket(ticketDto, rid, iid, oid, cid);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateTicket.do", method = RequestMethod.POST)
    public @ResponseBody Object update(@RequestParam("tid") Integer tid,
                                       @RequestParam("content") String content) {
        ticketService.updateTicket(tid, content);
        return "redirect:/";
    }

    @RequestMapping("/getTicketDatatable.do")
    public @ResponseBody Object getDatatable() {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", ticketService.getTicketList());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getTotalTicketListByTid.do", method = RequestMethod.POST)
    public @ResponseBody Object getTotalTicketListByTid(@RequestParam("tid") Integer tid) {
        return ticketService.getTotalTicketListByTid(tid);
    }

    @RequestMapping(value = "/getTotalTicketList.do", method = RequestMethod.POST)
    public @ResponseBody Object getTotalResultList() {
        return ticketService.getTotalTicketList();
    }

}
