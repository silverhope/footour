package com.footour.persistence.repositories;

import com.footour.persistence.entities.Passes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassesRepository extends JpaRepository<Passes, Long> {
}
