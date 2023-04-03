package com.CapgeTicketEvents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CapgeTicketEvents.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
