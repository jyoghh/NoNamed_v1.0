package jiho.marvel01.service;

import jiho.marvel01.domain.Entity.InspectGroupEntity;
import jiho.marvel01.domain.Repository.InspectGroupRepository;
import jiho.marvel01.dto.InspectGroupDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class InspectGroupService {
    private InspectGroupRepository inspectGroupRepository;

    @Transactional
    public Long saveInspectGroup(InspectGroupDto inspectGroupDto) {
        return inspectGroupRepository.save(inspectGroupDto.toEntity()).getIid();
    }

    @Transactional
    public void insertInspectGroup(InspectGroupDto inspectGroupDto, Map<String, String> infos, Long iid) {
        InspectGroupEntity inspectgroupEntity = inspectGroupDto.toEntity();
        inspectgroupEntity.setIid(iid);
        inspectgroupEntity.setIgName(infos.get("igName"));
        inspectgroupEntity.setObjects(infos.get("objects"));
        inspectgroupEntity.setManager(infos.get("manager"));
        inspectGroupRepository.save(inspectgroupEntity).getIgid();
    }

    @Transactional
    public List<InspectGroupDto> getInspectGrouplist() {
        List<InspectGroupEntity> inspectgroupEntities = inspectGroupRepository.findAll();
        List<InspectGroupDto> inspectgroupDtoList = new ArrayList<>();

        for(InspectGroupEntity inspectEntity : inspectgroupEntities) {
            InspectGroupDto inspectDTO = InspectGroupDto.builder()
                    .igid(inspectEntity.getIgid())
                    .iid(inspectEntity.getIid())
                    .igName(inspectEntity.getIgName())
                    .manager(inspectEntity.getManager())
                    .build();

            inspectgroupDtoList.add(inspectDTO);
        }
        return inspectgroupDtoList;
    }

}