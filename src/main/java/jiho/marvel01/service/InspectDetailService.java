package jiho.marvel01.service;

import jiho.marvel01.domain.Entity.InspectDetailEntity;
import jiho.marvel01.domain.Repository.InspectDetailRepository;
import jiho.marvel01.dto.InspectDetailDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.sql.Timestamp;
import java.util.*;

@AllArgsConstructor
@Service
public class InspectDetailService {
    private InspectDetailRepository inspectDetailRepository;

    @Transactional
    public Long saveInspect(InspectDetailDto inspectDetailDto) {
        return inspectDetailRepository.save(inspectDetailDto.toEntity()).getIdid();
    }

    @Transactional
    public void insertInspect(InspectDetailDto inspectDetailDto, Map<String, String> infos, Integer rid, Integer oid, Timestamp date) {
        InspectDetailEntity inspectDetailEntity = inspectDetailDto.toEntity();
        inspectDetailEntity.setRid(rid);
        inspectDetailEntity.setOid(oid);
        inspectDetailEntity.setDate(date);
        inspectDetailEntity.setResult(infos.get("result"));
        inspectDetailEntity.setStatus(infos.get("status"));
        inspectDetailRepository.save(inspectDetailEntity).getIdid();
    }

    @Transactional
    public void insertTestInspect(InspectDetailDto inspectDetailDto) {
        for(int i=0; i<21; i++) {
            InspectDetailEntity inspectdetailEntity = inspectDetailDto.toEntity();
            inspectdetailEntity.setRid(1);
            inspectdetailEntity.setOid(1);
            inspectdetailEntity.setResult("결과결과결과결과결과결과"+i);
            inspectdetailEntity.setStatus("상태"+i);
            inspectDetailRepository.save(inspectdetailEntity).getIdid();
        }
    }

    @Transactional
    public void updateInspect(Long idid, Map<String, String> infos, Integer rid, Integer oid, Timestamp date) {
        Optional<InspectDetailEntity> inspectDetailEntityWrapper = inspectDetailRepository.findById(idid);
        InspectDetailEntity inspectDetailEntity = inspectDetailEntityWrapper.get();
        inspectDetailEntity.setIdid(idid);
        inspectDetailEntity.setRid(rid);
        inspectDetailEntity.setOid(oid);
        inspectDetailEntity.setDate(date);
        inspectDetailEntity.setResult(infos.get("result"));
        inspectDetailEntity.setStatus(infos.get("status"));
        inspectDetailRepository.save(inspectDetailEntity);
    }

    @Transactional
    public List<InspectDetailDto> getInspectlist() {
        List<InspectDetailEntity> inspectEntities = inspectDetailRepository.findAll();
        List<InspectDetailDto> inspectDetailDtoList = new ArrayList<>();

        for(InspectDetailEntity inspectDetailEntity : inspectEntities) {
            InspectDetailDto inspectDetailDTO = InspectDetailDto.builder()
                    .idid(inspectDetailEntity.getIdid())
                    .rid(inspectDetailEntity.getRid())
                    .oid(inspectDetailEntity.getOid())
                    .date(inspectDetailEntity.getDate())
                    .result(inspectDetailEntity.getResult())
                    .status(inspectDetailEntity.getStatus())
                    .build();

            inspectDetailDtoList.add(inspectDetailDTO);
        }
        return inspectDetailDtoList;
    }

    @Transactional
    public List<InspectDetailDto> getInspectlistbyId(List<Long> idids) {
        List<InspectDetailEntity> inspectEntities = inspectDetailRepository.findAllById(idids);
        List<InspectDetailDto> inspectDetailDtoList = new ArrayList<>();

        for(InspectDetailEntity inspectDetailEntity : inspectEntities) {
            InspectDetailDto inspectDetailDTO = InspectDetailDto.builder()
                    .idid(inspectDetailEntity.getIdid())
                    .rid(inspectDetailEntity.getRid())
                    .oid(inspectDetailEntity.getOid())
                    .date(inspectDetailEntity.getDate())
                    .result(inspectDetailEntity.getResult())
                    .status(inspectDetailEntity.getStatus())
                    .build();

            inspectDetailDtoList.add(inspectDetailDTO);
        }
        return inspectDetailDtoList;
    }

    @Transactional
    public InspectDetailDto getInspect(Long idid) {
        Optional<InspectDetailEntity> inspectDetailEntityWrapper = inspectDetailRepository.findById(idid);
        InspectDetailEntity inspectDetailEntity = inspectDetailEntityWrapper.get();

        InspectDetailDto inspectDetailDto = InspectDetailDto.builder()
                .idid(inspectDetailEntity.getIdid())
                .rid(inspectDetailEntity.getRid())
                .oid(inspectDetailEntity.getOid())
                .date(inspectDetailEntity.getDate())
                .result(inspectDetailEntity.getResult())
                .status(inspectDetailEntity.getStatus())
                .build();

        return inspectDetailDto;
    }

    @Transactional
    public void deleteInspect(Long idid) {
        inspectDetailRepository.deleteById(idid);
    }

    @Transactional //idx 기준으로 조회하여 리스팅 후 유저 삭제
    public void deleteInspects(List<Long> idid) {
        List<InspectDetailEntity> inspectEntities = inspectDetailRepository.findAllById(idid);
        List<InspectDetailDto> inspectDetailDtoList = new ArrayList<>();

        for(InspectDetailEntity inspectDetailEntity : inspectEntities) {
            inspectDetailRepository.deleteById(inspectDetailEntity.getIdid());
        }
    }

}
