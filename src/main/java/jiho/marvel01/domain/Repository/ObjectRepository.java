package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<ObjectEntity, Long> {
}
