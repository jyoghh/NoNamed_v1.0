package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.InspectResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InspectResultRepository extends JpaRepository<InspectResultEntity, Integer> {
        List<InspectResultEntity> findByIid(Integer iid);
        List<InspectResultEntity> findByIidAndCidAndOid(Integer iid, Integer cid, Integer oid);
}
