package com.footour.persistence.repositories;

import com.footour.persistence.entities.Positioning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositioningRepository extends JpaRepository<Positioning, Long> {
}
