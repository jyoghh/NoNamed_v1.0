package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "role")
public class RoleEntity extends TimeEntity {

    public RoleEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    @Column(name = "regId")
    private Long regId;

    @Column(name = "gName")
    private String gName;

    @Column(name = "gCode")
    private String gCode;

    @Column(name = "regDate")
    private Timestamp regDate;

    @Builder
    public RoleEntity(Long rid, Long regId,String gName,String gCode, Timestamp regDate) {
        this.rid     = rid;
        this.regId   = regId;
        this.gName   = gName;
        this.gCode   = gCode;
        this.gCode   = gCode;
        this.regDate = regDate;
    }

}
