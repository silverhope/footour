package com.footour.persistence.repositories;

import com.footour.persistence.entities.Tackling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacklingRepository extends JpaRepository<Tackling, Long> {
}
