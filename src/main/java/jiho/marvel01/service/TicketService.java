package jiho.marvel01.service;

import jiho.marvel01.domain.Entity.TicketEntity;
import jiho.marvel01.domain.Repository.TicketRepository;
import jiho.marvel01.dto.TicketDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
@PersistenceContext
public class TicketService {

    private EntityManager em;
    private TicketRepository ticketRepository;

    @Transactional
    public void insertTicket(TicketDto ticketDto, Integer rid, Integer iid, Integer oid, Integer cid) {
        TicketEntity ticketEntity = ticketDto.toEntity();
        ticketEntity.setRid(rid);
        ticketEntity.setIid(iid);
        ticketEntity.setOid(oid);
        ticketEntity.setCid(cid);
        ticketEntity.setStatus("N");
        ticketRepository.save(ticketEntity).getTid();
    }

    @Transactional
    public void updateTicket(Integer tid, String content) {
        Optional<TicketEntity> ticketEntityWrapper = ticketRepository.findById(tid);
        TicketEntity ticketEntity = ticketEntityWrapper.get();
        ticketEntity.setCid(tid);
        ticketEntity.setContent(content);
        ticketEntity.setStatus("Y");
        ticketRepository.save(ticketEntity);
    }

    @Transactional
    public List<TicketDto> getTicketList() {
        List<TicketEntity> ticketEntities = ticketRepository.findAll();
        List<TicketDto> ticketDtoList = new ArrayList<>();

        for(TicketEntity ticketEntity : ticketEntities) {
            TicketDto ticketDTO = TicketDto.builder()
                    .tid(ticketEntity.getTid())
                    .iid(ticketEntity.getIid())
                    .rid(ticketEntity.getRid())
                    .oid(ticketEntity.getOid())
                    .content(ticketEntity.getContent())
                    .status(ticketEntity.getStatus())
                    .build();

            ticketDtoList.add(ticketDTO);
        }
        return ticketDtoList;
    }

    @Transactional
    public List<Object[]> getTotalTicketListByTid(Integer tid) {
        String jpql = "SELECT DISTINCT TE, CF, OBJ FROM TicketEntity TE, ConfluenceEntity CF, ObjectEntity OBJ WHERE "
                +"CF.cid = TE.cid AND OBJ.oid = TE.oid AND TE.tid = :tid";
        List<Object[]> totalResult = em.createQuery(jpql, Object[].class)
                .setParameter("tid",tid)
                .getResultList();
        return totalResult;
    }

    @Transactional
    public List<Object[]> getTotalTicketList() {
        String jpql = "SELECT DISTINCT TE, IE FROM TicketEntity TE, InspectEntity IE WHERE "
                +"IE.iid = TE.iid";
        List<Object[]> totalResult = em.createQuery(jpql, Object[].class)
                .getResultList();
        return totalResult;
    }

}
