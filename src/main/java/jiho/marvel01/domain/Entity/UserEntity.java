package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "user")
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Builder
    public UserEntity(Long uid, String email, String name) {
        this.uid = uid;
        this.email = email;
        this.name = name;
    }
}
