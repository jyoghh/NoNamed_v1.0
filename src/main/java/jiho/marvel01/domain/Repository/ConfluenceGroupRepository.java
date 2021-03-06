package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.ConfluenceGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfluenceGroupRepository extends JpaRepository<ConfluenceGroupEntity, Long> {
        List<ConfluenceGroupEntity> findByCgName(String cgName);
}
