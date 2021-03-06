package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.UserEntity;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private Long uid;
    private String name;
    private String email;
    private String corp;
    private String department;
    private String ranks;
    private String codes;
    private String password;
//    private String sessionKey;
//    private Timestamp sessionLimit;
    private String status;
    private Integer i_group;

    public UserEntity toEntity() {
        UserEntity userEntity = UserEntity.builder()
                .uid(uid)
                .name(name)
                .email(email)
                .corp(corp)
                .department(department)
                .ranks(ranks)
                .codes(codes)
                .password(password)
//                .sessionKey(sessionKey)
//                .sessionLimit(sessionLimit)
                .status(status)
                .i_group(i_group)
                .build();
        return userEntity;
    }

    @Builder
    public UserDto(Long uid, String email, String name, String corp, String department, String ranks, String codes, String password, String status, Integer i_group) {
        this.uid          = uid;
        this.email        = email;
        this.name         = name;
        this.corp         = corp;
        this.department   = department;
        this.ranks        = ranks;
        this.codes        = codes;
        this.password     = password;
//        this.sessionKey   = sessionKey;
//        this.sessionLimit = sessionLimit;
        this.status       = status;
        this.i_group      = i_group;
    }
}

