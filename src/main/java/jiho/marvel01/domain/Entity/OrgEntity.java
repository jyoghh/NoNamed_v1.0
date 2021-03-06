package jiho.marvel01.domain.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "organazation")
public class OrgEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    public OrgEntity() {
    }

//    회사코드
    @Column(name = "codes")
    private String codes;

//    회사명
    @Column(name = "name")
    private String name;

//    조직코드
    @Column(name = "oCode")
    private String oCode;

//    조직명
    @Column(name = "oName")
    private String oName;

//    조직영문명
    @Column(name = "oEngName")
    private String oEngName;

//    상위조직코드
    @Column(name = "upperCode")
    private String upperCode;

//    상위조직명
    @Column(name = "upperName")
    private String upperName;

//    상태
    @Column(name = "status")
    private String status;

//    순서
    @Column(name = "orders")
    private String orders;

//    최상위여부
    @Column(name = "topcheck")
    private Integer topcheck;

    @Builder
    public OrgEntity(Long oid, String codes, String name, String oCode, String oName, String oEngName, String upperCode, String upperName, String status, String orders, Integer topcheck) {
        this.oid        = oid;
        this.codes      = codes;
        this.name       = name;
        this.oCode      = oCode;
        this.oName      = oName;
        this.oEngName   = oEngName;
        this.upperCode  = upperCode;
        this.upperName  = upperName;
        this.status     = status;
        this.orders     = orders;
        this.topcheck   = topcheck;
    }
}