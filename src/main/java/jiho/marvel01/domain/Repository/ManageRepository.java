package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.ManageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManageRepository extends JpaRepository<ManageEntity, Long> {
}