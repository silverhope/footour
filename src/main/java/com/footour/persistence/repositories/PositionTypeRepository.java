package com.footour.persistence.repositories;

import com.footour.persistence.entities.PositionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionTypeRepository extends JpaRepository<PositionType, Integer> {
}
