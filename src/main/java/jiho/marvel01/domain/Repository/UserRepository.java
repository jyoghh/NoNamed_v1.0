package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
