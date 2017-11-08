package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Movement;
import com.footour.persistence.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    public List<Movement> getAllMovements() {
        return movementRepository.findAll();
    }

    public Page<Movement> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return movementRepository.findAll(pageRequest);
    }

    public Movement getById(Long id) throws FootourException {
        if (movementRepository.exists(id)) {
            return movementRepository.findOne(id);
        } else {
            throw new FootourException("The movement you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Movement createMovement(Movement movement) {
        //Checks for validation of player info
        return movementRepository.save(movement);
    }

    public Movement updateMovement(Long id, Movement movement) throws FootourException {
        if (movementRepository.exists(id)) {
            return movementRepository.save(movement);
        } else {
            throw new FootourException("The movement you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteMovement(Long id) throws FootourException {
        if (movementRepository.exists(id)) {
            movementRepository.delete(id);
        } else {
            throw new FootourException("The movement you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
