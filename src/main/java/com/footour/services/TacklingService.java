package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Tackling;
import com.footour.persistence.repositories.TacklingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacklingService {

    @Autowired
    private TacklingRepository tacklingRepository;

    public List<Tackling> getAllTacklings() {
        return tacklingRepository.findAll();
    }

    public Page<Tackling> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return tacklingRepository.findAll(pageRequest);
    }

    public Tackling getById(Long id) throws FootourException {
        if (tacklingRepository.exists(id)) {
            return tacklingRepository.findOne(id);
        } else {
            throw new FootourException("The tackling you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Tackling createTackling(Tackling tackling) {
        //Checks for validation of player info
        return tacklingRepository.save(tackling);
    }

    public Tackling updateTackling(Long id, Tackling tackling) throws FootourException {
        if (tacklingRepository.exists(id)) {
            return tacklingRepository.save(tackling);
        } else {
            throw new FootourException("The tackling you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteTackling(Long id) throws FootourException {
        if (tacklingRepository.exists(id)) {
            tacklingRepository.delete(id);
        } else {
            throw new FootourException("The tackling you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
