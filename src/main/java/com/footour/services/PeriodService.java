package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Period;
import com.footour.persistence.repositories.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodService {
    
    @Autowired
    private PeriodRepository periodRepository;

    public List<Period> getAllPeriods() {
        return periodRepository.findAll();
    }

    public Page<Period> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return periodRepository.findAll(pageRequest);
    }

    public Period getById(Integer id) throws FootourException {
        if (periodRepository.exists(id)) {
            return periodRepository.findOne(id);
        } else {
            throw new FootourException("The period you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Period createPeriod(Period period) {
        //Checks for validation of player info
        return periodRepository.save(period);
    }

    public Period updatePeriod(Integer id, Period period) throws FootourException {
        if (periodRepository.exists(id)) {
            return periodRepository.save(period);
        } else {
            throw new FootourException("The period you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deletePeriod(Integer id) throws FootourException {
        if (periodRepository.exists(id)) {
            periodRepository.delete(id);
        } else {
            throw new FootourException("The period you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
