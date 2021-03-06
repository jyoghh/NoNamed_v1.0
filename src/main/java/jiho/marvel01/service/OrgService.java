package jiho.marvel01.service;

import jiho.marvel01.domain.Entity.OrgEntity;
import jiho.marvel01.domain.Repository.OrgRepository;
import jiho.marvel01.dto.OrgDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrgService {
    private OrgRepository orgRepository;

    @Transactional
    public Long save(OrgDto orgDto) {
        return orgRepository.save(orgDto.toEntity()).getOid();
    }

    @Transactional
    public void update(Long oid, Map<String, String> infos, Integer topcheck) {
        Optional<OrgEntity> orgEntityWrapper = orgRepository.findById(oid);
        OrgEntity orgEntity = orgEntityWrapper.get();
        orgEntity.setCodes(infos.get("codes"));
        orgEntity.setName(infos.get("name"));
        orgEntity.setOCode(infos.get("oCode"));
        orgEntity.setOCode(infos.get("oName"));
        orgEntity.setOEngName(infos.get("oEngName"));
        orgEntity.setUpperCode(infos.get("upperCode"));
        orgEntity.setUpperName(infos.get("upperName"));
        orgEntity.setStatus(infos.get("status"));
        orgEntity.setStatus(infos.get("orders"));
        orgEntity.setTopcheck(topcheck);
        orgRepository.save(orgEntity);
    }

    @Transactional
    public void updateUpperCode(Long oid, String UpperCode) {
        Optional<OrgEntity> orgEntityWrapper = orgRepository.findById(oid);
        OrgEntity orgEntity = orgEntityWrapper.get();
        orgEntity.setUpperCode(UpperCode);
        orgRepository.save(orgEntity);
    }

    @Transactional
    public List<OrgDto> getList() {
        List<OrgEntity> orgEntities = orgRepository.findAll();
        List<OrgDto> orgDtoList = new ArrayList<>();

        for(OrgEntity orgEntity : orgEntities) {
            OrgDto orgDTO = OrgDto.builder()
                    .oid(orgEntity.getOid())
                    .codes(orgEntity.getCodes())
                    .name(orgEntity.getName())
                    .oCode(orgEntity.getOCode())
                    .oName(orgEntity.getOName())
                    .oEngName(orgEntity.getOEngName())
                    .upperCode(orgEntity.getUpperCode())
                    .upperName(orgEntity.getUpperName())
                    .status(orgEntity.getStatus())
                    .orders(orgEntity.getOrders())
                    .topcheck(orgEntity.getTopcheck())
                    .build();

            orgDtoList.add(orgDTO);
        }
        return orgDtoList;
    }

    @Transactional
    public List<OrgDto> getListbyId(List<Long> oids) {
        List<OrgEntity> orgEntities = orgRepository.findAllById(oids);
        List<OrgDto> orgDtoList = new ArrayList<>();

        for(OrgEntity orgEntity : orgEntities) {
            OrgDto orgDTO = OrgDto.builder()
                    .oid(orgEntity.getOid())
                    .codes(orgEntity.getCodes())
                    .name(orgEntity.getName())
                    .oCode(orgEntity.getOCode())
                    .oName(orgEntity.getOName())
                    .oEngName(orgEntity.getOEngName())
                    .upperCode(orgEntity.getUpperCode())
                    .upperName(orgEntity.getUpperName())
                    .status(orgEntity.getStatus())
                    .orders(orgEntity.getOrders())
                    .topcheck(orgEntity.getTopcheck())
                    .build();

            orgDtoList.add(orgDTO);
        }
        return orgDtoList;
    }

    @Transactional
    public OrgDto getOne(Long oid) {
        Optional<OrgEntity> orgEntityWrapper = orgRepository.findById(oid);
        OrgEntity orgEntity = orgEntityWrapper.get();

        OrgDto orgDTO = OrgDto.builder()
                .oid(orgEntity.getOid())
                .codes(orgEntity.getCodes())
                .name(orgEntity.getName())
                .oCode(orgEntity.getOCode())
                .oName(orgEntity.getOName())
                .oEngName(orgEntity.getOEngName())
                .upperCode(orgEntity.getUpperCode())
                .upperName(orgEntity.getUpperName())
                .status(orgEntity.getStatus())
                .orders(orgEntity.getOrders())
                .topcheck(orgEntity.getTopcheck())
                .build();

        return orgDTO;
    }

    @Transactional
    public List<OrgDto> getTopOrgs(Integer topcheck) {
        List<OrgEntity> topOrgs = orgRepository.findByTopcheck(1);
        List<OrgDto> orgDtoList = new ArrayList<>();

        for(OrgEntity orgEntity : topOrgs) {
            OrgDto orgDTO = OrgDto.builder()
                    .oid(orgEntity.getOid())
                    .codes(orgEntity.getCodes())
                    .name(orgEntity.getName())
                    .oCode(orgEntity.getOCode())
                    .oName(orgEntity.getOName())
                    .oEngName(orgEntity.getOEngName())
                    .upperCode(orgEntity.getUpperCode())
                    .upperName(orgEntity.getUpperName())
                    .status(orgEntity.getStatus())
                    .orders(orgEntity.getOrders())
                    .topcheck(orgEntity.getTopcheck())
                    .build();

            orgDtoList.add(orgDTO);

        }
        return orgDtoList;
    }

    @Transactional
    public List<OrgDto> getUpperCode(String upperName) {
        List<OrgEntity> Orgs = orgRepository.findByUpperName(upperName);
        List<OrgDto> orgDtoList = new ArrayList<>();

        for(OrgEntity orgEntity : Orgs) {
            OrgDto orgDTO = OrgDto.builder()
                    .upperCode(orgEntity.getUpperCode())
                    .build();

            orgDtoList.add(orgDTO);
        }
        return orgDtoList;
    }

    @Transactional //idx ???????????? ???????????? ????????? ??? ?????? ??????
    public void delete(List<Long> oid) {
        List<OrgEntity> orgEntities = orgRepository.findAllById(oid);
        List<OrgDto> orgDtoList = new ArrayList<>();

        for(OrgEntity orgEntity : orgEntities) {
            orgRepository.deleteById(orgEntity.getOid());
        }
    }


}
