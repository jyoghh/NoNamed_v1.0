package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.ManageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManageRepository extends JpaRepository<ManageEntity, Long> {
    List<ManageEntity> findAllByIid(Long iid);
}
