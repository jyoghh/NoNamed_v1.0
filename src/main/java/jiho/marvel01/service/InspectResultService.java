package jiho.marvel01.service;

import jiho.marvel01.domain.Entity.InspectResultEntity;
import jiho.marvel01.domain.Repository.InspectResultRepository;
import jiho.marvel01.dto.InspectResultDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class InspectResultService {
    private InspectResultRepository inspectResultRepository;

    @Transactional
    public Integer saveInspectResult(InspectResultDto inspectResultDto) {
        return inspectResultRepository.save(inspectResultDto.toEntity()).getRid();
    }

    // 빠른 디버깅을 위한 더미 insert
    @Transactional
    public void insertTestInspectResult(InspectResultDto inspectResultDto) {
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        for(int i=0; i<21; i++) {
            InspectResultEntity inspectResultEntity = inspectResultDto.toEntity();
            inspectResultEntity.setRid(i);
            inspectResultEntity.setIid(1);
            inspectResultEntity.setOid(i);
            inspectResultEntity.setCid(i);
            inspectResultEntity.setDate(timestamp);
            inspectResultEntity.setResult(i+"번째 점검결과는 이렇습니다");
            inspectResultEntity.setStatus("상태"+i);
            inspectResultRepository.save(inspectResultEntity).getOid();
        }
    }

    @Transactional
    public List<InspectResultDto> getInspectResultlist() {
        List<InspectResultEntity> inspectresultEntities = inspectResultRepository.findAll();
        List<InspectResultDto> inspectresultDtoList = new ArrayList<>();

        for(InspectResultEntity inspectresultEntity : inspectresultEntities) {
            InspectResultDto inspectresultDTO = InspectResultDto.builder()
                    .rid(inspectresultEntity.getRid())
                    .iid(inspectresultEntity.getIid())
                    .oid(inspectresultEntity.getOid())
                    .cid(inspectresultEntity.getCid())
                    .date(inspectresultEntity.getDate())
                    .result(inspectresultEntity.getResult())
                    .status(inspectresultEntity.getStatus())
                    .build();

            inspectresultDtoList.add(inspectresultDTO);
        }
        return inspectresultDtoList;
    }

    @Transactional
    public List<InspectResultDto> getByIid(Integer iid) {
        List<InspectResultEntity> ListByIid = inspectResultRepository.findByIid(iid);
        List<InspectResultDto> inspectResultDtoList = new ArrayList<>();

        for(InspectResultEntity inspectresultEntity : ListByIid) {
            InspectResultDto inspectresultDTO = InspectResultDto.builder()
                    .rid(inspectresultEntity.getRid())
                    .iid(inspectresultEntity.getIid())
                    .oid(inspectresultEntity.getOid())
                    .cid(inspectresultEntity.getCid())
                    .date(inspectresultEntity.getDate())
                    .result(inspectresultEntity.getResult())
                    .status(inspectresultEntity.getStatus())
                    .build();

            inspectResultDtoList.add(inspectresultDTO);

        }
        return inspectResultDtoList;
    }

}