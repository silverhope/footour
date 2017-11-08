package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Positioning;
import com.footour.persistence.repositories.PositioningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositioningService {
    
    @Autowired
    private PositioningRepository positioningRepository;

    public List<Positioning> getAllPositionings() {
        return positioningRepository.findAll();
    }

    public Page<Positioning> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return positioningRepository.findAll(pageRequest);
    }

    public Positioning getById(Long id) throws FootourException {
        if (positioningRepository.exists(id)) {
            return positioningRepository.findOne(id);
        } else {
            throw new FootourException("The positioning you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Positioning createPositioning(Positioning positioning) {
        //Checks for validation of player info
        return positioningRepository.save(positioning);
    }

    public Positioning updatePositioning(Long id, Positioning positioning) throws FootourException {
        if (positioningRepository.exists(id)) {
            return positioningRepository.save(positioning);
        } else {
            throw new FootourException("The positioning you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deletePositioning(Long id) throws FootourException {
        if (positioningRepository.exists(id)) {
            positioningRepository.delete(id);
        } else {
            throw new FootourException("The positioning you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
