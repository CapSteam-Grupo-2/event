package com.capgeticketevents.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgeticketevents.model.Location;


@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

}
