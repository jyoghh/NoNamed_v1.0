package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.InspectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectRepository extends JpaRepository<InspectEntity, Long> {
}
