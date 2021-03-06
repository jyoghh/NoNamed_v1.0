package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    public UserEntity() {}

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "corp")
    private String corp;

    @Column(name = "department")
    private String department;

    @Column(name = "status")
    private String status;

    @Column(name = "ranks")
    private String ranks;

    @Column(name = "codes")
    private String codes;

    @Column(name = "password")
    private String password;

    @Column(name = "i_group")
    private Integer i_group;

    @Builder
    public UserEntity(Long uid, String email, String name, String corp, String department, String ranks, String codes, String password, String status, Integer i_group) {
        this.uid          = uid;
        this.email        = email;
        this.name         = name;
        this.corp         = corp;
        this.department   = department;
        this.ranks        = ranks;
        this.codes        = codes;
        this.password     = password;
        this.status       = status;
        this.i_group      = i_group;
    }
    
    public String getUsername() {
        return email;
    }
}
