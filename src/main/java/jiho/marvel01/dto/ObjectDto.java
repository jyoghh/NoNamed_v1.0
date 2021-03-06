package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.ObjectEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ObjectDto {
    private Long oid;
    private String type;
    private String oName;
    private String purpose;
    private String oGroup;
    private String part1;
    private String part2;
    private String IP;
    private String location;

    public ObjectEntity toEntity() {
        ObjectEntity objectEntity = ObjectEntity.builder()
                .oid(oid)
                .oName(oName)
                .type(type)
                .purpose(purpose)
                .oGroup(oGroup)
                .part1(part1)
                .part2(part2)
                .IP(IP)
                .location(location)
                .build();
        return objectEntity;
    }

   @Builder
    public ObjectDto(Long oid, String type, String oName , String purpose , String oGroup , String part1 , String part2 , String IP , String location) {
        this.oid        = oid;
        this.type       = type;
        this.oName      = oName;
        this.purpose    = purpose;
        this.oGroup     = oGroup;
        this.part2      = part2;
        this.part1      = part1;
        this.IP         = IP;
        this.location   =  location;
    }

}
