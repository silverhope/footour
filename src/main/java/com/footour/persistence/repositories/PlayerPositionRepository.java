/*
 * Copyright (c) 2017.
 */

package com.footour.persistence.repositories;

import com.footour.persistence.entities.PlayerPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerPositionRepository extends JpaRepository<PlayerPosition, Long> {
}
