package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
