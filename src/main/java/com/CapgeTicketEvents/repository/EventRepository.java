package com.CapgeTicketEvents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CapgeTicketEvents.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}
