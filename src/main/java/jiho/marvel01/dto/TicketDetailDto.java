package jiho.marvel01.dto;

import lombok.*;

@Getter
@Setter
public class TicketDetailDto{
    private Long tdid;
    private Long tid;
    private Long aid;
    private String content;

    @Builder
    public TicketDetailDto(Long tdid, Long tid, Long aid, String content) {
        this.tdid     = tdid;
        this.tid     = tid;
        this.aid     = aid;
        this.content = content;
    }

}
