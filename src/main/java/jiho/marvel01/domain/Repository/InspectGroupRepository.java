package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.InspectGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InspectGroupRepository extends JpaRepository<InspectGroupEntity, Long> {
}
