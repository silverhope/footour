package com.footour.persistence.repositories;

import com.footour.persistence.entities.TeamStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamStatisticsRepository extends JpaRepository<TeamStatistics, Integer> {
}
