package jiho.marvel01.domain.Repository;

import jiho.marvel01.domain.Entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
