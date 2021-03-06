package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.OrgEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrgRepository extends JpaRepository<OrgEntity, Long> {
    List<OrgEntity> findByTopcheck(Integer top_check);
    List<OrgEntity> findByUpperName(String upperName);
}
