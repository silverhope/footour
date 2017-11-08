package com.footour.persistence.repositories;

import com.footour.persistence.entities.BallRetention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallRetentionRepository extends JpaRepository<BallRetention, Long> {
}
