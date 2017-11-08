/*
 * Copyright (c) 2017.
 */

package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.PlayerPosition;
import com.footour.persistence.repositories.PlayerPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerPositionService {
    @Autowired
    private PlayerPositionRepository playerPositionRepository;

    public List<PlayerPosition> getAllPositions() {
        return playerPositionRepository.findAll();
    }

    public Page<PlayerPosition> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return playerPositionRepository.findAll(pageRequest);
    }

    public PlayerPosition getById(Long id) throws FootourException {
        if (playerPositionRepository.exists(id)) {
            return playerPositionRepository.findOne(id);
        } else {
            throw new FootourException("The player-position you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public PlayerPosition createPosition(PlayerPosition position) {
        //Checks for validation of player info
        return playerPositionRepository.save(position);
    }

    public PlayerPosition updatePosition(Long id, PlayerPosition playerPosition) throws FootourException {
        if (playerPositionRepository.exists(id)) {
            return playerPositionRepository.save(playerPosition);
        } else {
            throw new FootourException("The player-position you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deletePosition(Long id) throws FootourException {
        if (playerPositionRepository.exists(id)) {
            playerPositionRepository.delete(id);
        } else {
            throw new FootourException("The player-position you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
