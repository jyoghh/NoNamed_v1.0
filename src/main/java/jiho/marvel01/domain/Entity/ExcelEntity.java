package jiho.marvel01.domain.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcelEntity {
    private String name;
    private String email;
    private String corp;
    private String department;
    private String status;
    private String ranks;
    private String codes;
    private Integer i_group;

    @Builder
    public ExcelEntity(String name, String email, String corp, String department, String status, String ranks, String codes, Integer i_group) {
        this.name = name;
        this.email = email;
        this.corp = corp;
        this.department = department;
        this.status = status;
        this.ranks= ranks;
        this.codes = codes;
        this.i_group = i_group;
    }

}
