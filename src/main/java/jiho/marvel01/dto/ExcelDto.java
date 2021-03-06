package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.ExcelEntity;
import lombok.Builder;

public class ExcelDto {

    private String name;
    private String email;
    private String corp;
    private String department;
    private String status;
    private String ranks;
    private String codes;
    private Integer i_group;

    public ExcelEntity toEntity() {
        ExcelEntity excelEntity = ExcelEntity.builder()
                .name(name)
                .email(email)
                .corp(corp)
                .department(department)
                .status(status)
                .ranks(ranks)
                .codes(codes)
                .i_group(i_group)
                .build();
        return excelEntity;
    }

    @Builder
    public ExcelDto(String name, String email, String corp, String department, String status, String ranks, String codes, Integer i_group) {
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
