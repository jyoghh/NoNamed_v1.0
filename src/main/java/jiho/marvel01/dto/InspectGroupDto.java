package jiho.marvel01.dto;

import lombok.*;

@Getter
@Setter
public class InspectGroupDto {

    private Long igid;
    private Long iid;
    private Long oid;

    @Builder
    public InspectGroupDto(Long igid, Long iid, Long oid) {
        this.igid  = igid;
        this.iid  = iid;
        this.oid  = oid;
    }

}
