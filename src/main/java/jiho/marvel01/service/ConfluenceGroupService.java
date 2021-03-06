package jiho.marvel01.service;

import jiho.marvel01.domain.Entity.ConfluenceEntity;
import jiho.marvel01.domain.Entity.ConfluenceGroupEntity;
import jiho.marvel01.domain.Repository.ConfluenceGroupRepository;
import jiho.marvel01.dto.ConfluenceDto;
import jiho.marvel01.dto.ConfluenceGroupDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ConfluenceGroupService {
    private ConfluenceGroupRepository confluenceGroupRepository;

    @Transactional
    public Long saveConfluenceGroup(ConfluenceGroupDto confluenceGroupDto) {
        return confluenceGroupRepository.save(confluenceGroupDto.toEntity()).getCgid();
    }
    // 빠른 디버깅을 위한 더미 insert
    @Transactional
    public void insertTestConfluenceGroup(ConfluenceGroupDto confluenceGroupDto) {
        for(long i=0; i<5; i++) {
            ConfluenceGroupEntity confluencegroupEntity = confluenceGroupDto.toEntity();
            confluencegroupEntity.setCgName("테스트그룹" + i);
            confluencegroupEntity.setConfs("1, 2, 3, 4, 5");
            confluenceGroupRepository.save(confluencegroupEntity).getCgid();
        }
    }
    @Transactional
    public void insertConfluenceGroup(ConfluenceGroupDto confluenceGroupDto, Map<String, String> infos) {
        ConfluenceGroupEntity confluencegroupEntity = confluenceGroupDto.toEntity();
        confluencegroupEntity.setCgName(infos.get("cgName"));
        confluencegroupEntity.setConfs(infos.get("confs"));
        confluenceGroupRepository.save(confluencegroupEntity).getCgid();
    }

    @Transactional
    public void updateConfluenceGroup(Long cgid, Map<String, String> infos) {
        Optional<ConfluenceGroupEntity> confluenceEntityWrapper = confluenceGroupRepository.findById(cgid);
        ConfluenceGroupEntity confluenceEntity = confluenceEntityWrapper.get();
        confluenceEntity.setCgid(cgid);
        confluenceEntity.setCgName(infos.get("cgName"));
        confluenceEntity.setConfs(infos.get("confs"));
        confluenceGroupRepository.save(confluenceEntity);
    }

    @Transactional
    public List<ConfluenceGroupDto> getConfluenceGrouplist() {
        List<ConfluenceGroupEntity> confluencegroupEntities = confluenceGroupRepository.findAll();
        List<ConfluenceGroupDto> confluencegroupDtoList = new ArrayList<>();

        for(ConfluenceGroupEntity confluenceEntity : confluencegroupEntities) {
            ConfluenceGroupDto confluenceDTO = ConfluenceGroupDto.builder()
                    .cgid(confluenceEntity.getCgid())
                    .cgName(confluenceEntity.getCgName())
                    .confs(confluenceEntity.getConfs())
                    .build();

            confluencegroupDtoList.add(confluenceDTO);
        }
        return confluencegroupDtoList;
    }

    @Transactional
    public ConfluenceGroupDto getConfluenceGroup(Long cgid) {
        Optional<ConfluenceGroupEntity> confluenceGroupEntityWrapper = confluenceGroupRepository.findById(cgid);
        ConfluenceGroupEntity confluenceGroupEntity = confluenceGroupEntityWrapper.get();

        ConfluenceGroupDto confluenceGroupDto = ConfluenceGroupDto.builder()
                .cgid(confluenceGroupEntity.getCgid())
                .cgName(confluenceGroupEntity.getCgName())
                .confs(confluenceGroupEntity.getConfs())
                .build();

        return confluenceGroupDto;
    }

    @Transactional //idx 기준으로 조회하여 리스팅 후 유저 삭제
    public void deleteConfluenceGroups(List<Long> cgid) {
        List<ConfluenceGroupEntity> confluenceGroupEntities = confluenceGroupRepository.findAllById(cgid);
        List<ConfluenceGroupDto> confluenceGroupDtoList = new ArrayList<>();

        for(ConfluenceGroupEntity confluenceGroupEntity : confluenceGroupEntities) {
            confluenceGroupRepository.deleteById(confluenceGroupEntity.getCgid());
        }
    }

    @Transactional
    public List<ConfluenceGroupDto> getConfluenceGroupsBycgname(String cgName) {
        List<ConfluenceGroupEntity> res = confluenceGroupRepository.findByCgName(cgName);
        List<ConfluenceGroupDto> cgDtoList = new ArrayList<>();
        for(ConfluenceGroupEntity confluenceGroupEntity : res) {
            ConfluenceGroupDto cgDTO = ConfluenceGroupDto.builder()
                    .cgid(confluenceGroupEntity.getCgid())
                    .cgName(confluenceGroupEntity.getCgName())
                    .confs(confluenceGroupEntity.getConfs())
                    .build();
            cgDtoList.add(cgDTO);
        }
        return cgDtoList;
    }

}
