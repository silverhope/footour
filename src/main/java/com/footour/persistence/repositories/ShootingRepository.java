package com.footour.persistence.repositories;

import com.footour.persistence.entities.Shooting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShootingRepository extends JpaRepository<Shooting, Long> {
}
