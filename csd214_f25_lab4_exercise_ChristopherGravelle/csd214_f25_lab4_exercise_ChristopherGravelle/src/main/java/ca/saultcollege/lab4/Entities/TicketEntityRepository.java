package ca.saultcollege.lab4.repositories;

import ca.saultcollege.lab4.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketEntityRepository extends JpaRepository<TicketEntity, Long> {
}