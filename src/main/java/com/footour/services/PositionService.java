package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Position;
import com.footour.persistence.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    
    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Page<Position> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return positionRepository.findAll(pageRequest);
    }

    public Position getById(Integer id) throws FootourException {
        if (positionRepository.exists(id)) {
            return positionRepository.findOne(id);
        } else {
            throw new FootourException("The position you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Position createPosition(Position position) {
        //Checks for validation of player info
        return positionRepository.save(position);
    }

    public Position updatePosition(Integer id, Position position) throws FootourException {
        if (positionRepository.exists(id)) {
            return positionRepository.save(position);
        } else {
            throw new FootourException("The position you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deletePosition(Integer id) throws FootourException {
        if (positionRepository.exists(id)) {
            positionRepository.delete(id);
        } else {
            throw new FootourException("The position you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
