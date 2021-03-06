package jiho.marvel01.service;

import jiho.marvel01.domain.Entity.ManageEntity;
import jiho.marvel01.domain.Repository.ManageRepository;
import jiho.marvel01.dto.ManageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@Service
@PersistenceContext
public class ManageService {

    private EntityManager em;

    private ManageRepository manageRepository;

    @Transactional
    public Long saveManage(ManageDto measureDto) {
        return manageRepository.save(measureDto.toEntity()).getIid();
    }

    @Transactional
    public void insertManage(ManageDto measureDto, Map<String, String> infos, Long iid, Long rid, Date stDate, Date exDate, Long aid) {
        ManageEntity manageEntity = measureDto.toEntity();
        manageEntity.setIid(iid);
        manageEntity.setRid(rid);
        manageEntity.setType(infos.get("type"));
        manageEntity.setStDate(stDate);
        manageEntity.setExDate(exDate);
        manageEntity.setComment(infos.get("comment"));
        manageEntity.setStatus(infos.get("status"));
        manageEntity.setAid(aid);
        manageRepository.save(manageEntity).getMid();
    }

    @Transactional
    public void insertAutoManage(ManageDto measureDto, Map<String, String> infos, Long iid, Long rid, Long aid) {
        ManageEntity manageEntity = measureDto.toEntity();
        Date date_now = new Date(System.currentTimeMillis());
        manageEntity.setIid(iid);
        manageEntity.setRid(rid);
        manageEntity.setType(infos.get("type"));
        manageEntity.setStDate(date_now);
        manageEntity.setExDate(date_now);
        manageEntity.setComment("ν΄λΉμμ");
        manageEntity.setStatus("Y");
        manageEntity.setAid(aid);
        manageRepository.save(manageEntity).getMid();
    }

    @Transactional
    public void insertYManage(ManageDto measureDto, Map<String, String> infos, Long iid, Long rid, Long aid) {
        ManageEntity manageEntity = measureDto.toEntity();
        Date date_now = new Date(System.currentTimeMillis());
        manageEntity.setIid(iid);
        manageEntity.setRid(rid);
        manageEntity.setType(infos.get("type"));
        manageEntity.setStDate(date_now);
        manageEntity.setExDate(date_now);
        manageEntity.setComment("μ€μ");
        manageEntity.setStatus("Y");
        manageEntity.setAid(aid);
        manageRepository.save(manageEntity).getMid();
    }

    @Transactional
    public void updateManage(Map<String, String> infos, Long mid) {
        Optional<ManageEntity> manageEntityWrapper = manageRepository.findById(mid);
        ManageEntity manageEntity = manageEntityWrapper.get();
        manageEntity.setMid(mid);
        manageEntity.setType(infos.get("type"));
        manageEntity.setComment(infos.get("comment"));
        manageEntity.setStatus(infos.get("status"));
        manageRepository.save(manageEntity);
    }

    @Transactional
    public List<ManageDto> getManagelist() {
        List<ManageEntity> manageEntities = manageRepository.findAll();
        List<ManageDto> measureDtoList = new ArrayList<>();

        for(ManageEntity manageEntity : manageEntities) {
            ManageDto manageDTO = ManageDto.builder()
                    .mid(manageEntity.getMid())
                    .iid(manageEntity.getIid())
                    .rid(manageEntity.getRid())
                    .type(manageEntity.getType())
                    .stDate(manageEntity.getStDate())
                    .exDate(manageEntity.getExDate())
                    .comment(manageEntity.getComment())
                    .status(manageEntity.getStatus())
                    .aid(manageEntity.getAid())
                    .build();

            measureDtoList.add(manageDTO);
        }
        return measureDtoList;
    }

    @Transactional
    public List<ManageDto> getManagelistbyId(List<Long> mid) {
        List<ManageEntity> manageEntities = manageRepository.findAllById(mid);
        List<ManageDto> measureDtoList = new ArrayList<>();

        for(ManageEntity manageEntity : manageEntities) {
            ManageDto manageDTO = ManageDto.builder()
                    .mid(manageEntity.getMid())
                    .iid(manageEntity.getIid())
                    .rid(manageEntity.getRid())
                    .type(manageEntity.getType())
                    .stDate(manageEntity.getStDate())
                    .exDate(manageEntity.getExDate())
                    .comment(manageEntity.getComment())
                    .status(manageEntity.getStatus())
                    .aid(manageEntity.getAid())
                    .build();

            measureDtoList.add(manageDTO);
        }
        return measureDtoList;
    }

    @Transactional
    public List<Object[]> getManagelistbyIid(Long iid) {
        String jpql = "SELECT DISTINCT ME, IE, OBJ, CE FROM InspectResultEntity IE, ManageEntity ME, ObjectEntity OBJ , ConfluenceEntity CE WHERE "
                +"IE.rid = ME.rid AND IE.oid = OBJ.oid AND IE.cid = CE.cid AND ME.iid = :iid";
        List<Object[]> totalResult = em.createQuery(jpql, Object[].class)
                .setParameter("iid",iid)
                .getResultList();
        return totalResult;
    }

    @Transactional
    public List<Object[]> getRAs() {
        String jpql = "SELECT COUNT(ME) FROM ManageEntity ME WHERE ME.type = :type";
        List<Object[]> list = em.createQuery(jpql, Object[].class).setParameter("type","ra").getResultList();
        return list;
    }

    @Transactional
    public List<Object[]> getNAs() {
        String jpql = "SELECT COUNT(ME) FROM ManageEntity ME WHERE ME.type = :type";
        List<Object[]> list = em.createQuery(jpql, Object[].class).setParameter("type","na").getResultList();
        return list;
    }

//    @Transactional
//    public List<ManageDto> getManagelistbyIid(Long iid) {
//        List<ManageEntity> manageEntities = manageRepository.findAllByIid(iid);
//        List<ManageDto> measureDtoList = new ArrayList<>();
//
//        for(ManageEntity manageEntity : manageEntities) {
//            ManageDto manageDTO = ManageDto.builder()
//                    .mid(manageEntity.getMid())
//                    .iid(manageEntity.getIid())
//                    .rid(manageEntity.getRid())
//                    .type(manageEntity.getType())
//                    .stDate(manageEntity.getStDate())
//                    .exDate(manageEntity.getExDate())
//                    .comment(manageEntity.getComment())
//                    .status(manageEntity.getStatus())
//                    .aid(manageEntity.getAid())
//                    .build();
//
//            measureDtoList.add(manageDTO);
//        }
//        return measureDtoList;
//    }

    @Transactional
    public ManageDto getManage(Long mid) {
        Optional<ManageEntity> manageEntityWrapper = manageRepository.findById(mid);
        ManageEntity manageEntity = manageEntityWrapper.get();

        ManageDto measureDto = ManageDto.builder()
                .mid(manageEntity.getMid())
                .iid(manageEntity.getIid())
                .rid(manageEntity.getRid())
                .type(manageEntity.getType())
                .stDate(manageEntity.getStDate())
                .exDate(manageEntity.getExDate())
                .comment(manageEntity.getComment())
                .status(manageEntity.getStatus())
                .aid(manageEntity.getAid())
                .build();

        return measureDto;
    }

    @Transactional
    public void deleteManage(Long mid) {
        manageRepository.deleteById(mid);
    }

    @Transactional //idx κΈ°μ€μΌλ‘ μ‘°ννμ¬ λ¦¬μ€ν ν μ μ  μ­μ 
    public void deleteManages(List<Long> mid) {
        List<ManageEntity> manageEntities = manageRepository.findAllById(mid);
        List<ManageDto> measureDtoList = new ArrayList<>();

        for(ManageEntity manageEntity : manageEntities) {
            manageRepository.deleteById(manageEntity.getMid());
        }
    }
}
