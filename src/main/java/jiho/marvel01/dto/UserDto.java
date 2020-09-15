package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.UserEntity;
import lombok.*;

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

    private String status;
    private Integer i_group;

    public UserEntity toEntity() {
        UserEntity userEntity = UserEntity.builder()
                .uid(uid)
                .name(name)
                .email(email)
                .corp(corp)
                .department(department)
                .status(status)
                .i_group(i_group)
                .build();
        return userEntity;
    }

    @Builder
    public UserDto(Long uid, String email, String name, String corp, String department, String status, Integer i_group) {
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.corp = corp;
        this.department = department;

        this.status = status;
        this.i_group = i_group;
    }
}

