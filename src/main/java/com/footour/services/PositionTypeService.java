package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.PositionType;
import com.footour.persistence.repositories.PositionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionTypeService {
    @Autowired
    private PositionTypeRepository positionTypeRepository;

    public List<PositionType> getAllPositionTypes() {
        return positionTypeRepository.findAll();
    }

    public Page<PositionType> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return positionTypeRepository.findAll(pageRequest);
    }

    public PositionType getById(Integer id) throws FootourException {
        if (positionTypeRepository.exists(id)) {
            return positionTypeRepository.findOne(id);
        } else {
            throw new FootourException("The positionType you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public PositionType createPositionType(PositionType positionType) {
        //Checks for validation of player info
        return positionTypeRepository.save(positionType);
    }

    public PositionType updatePositionType(Integer id, PositionType positionType) throws FootourException {
        if (positionTypeRepository.exists(id)) {
            return positionTypeRepository.save(positionType);
        } else {
            throw new FootourException("The positionType you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deletePositionType(Integer id) throws FootourException {
        if (positionTypeRepository.exists(id)) {
            positionTypeRepository.delete(id);
        } else {
            throw new FootourException("The positionType you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
