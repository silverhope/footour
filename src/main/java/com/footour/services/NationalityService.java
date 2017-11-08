package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Nationality;
import com.footour.persistence.repositories.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    public List<Nationality> getAllNationalities() {
        return nationalityRepository.findAll();
    }

    public Page<Nationality> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return nationalityRepository.findAll(pageRequest);
    }

    public Nationality getById(Integer id) throws FootourException {
        if (nationalityRepository.exists(id)) {
            return nationalityRepository.findOne(id);
        } else {
            throw new FootourException("The nationality you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Nationality createNationality(Nationality nationality) {
        //Checks for validation of player info
        return nationalityRepository.save(nationality);
    }

    public Nationality updateNationality(Integer id, Nationality nationality) throws FootourException {
        if (nationalityRepository.exists(id)) {
            return nationalityRepository.save(nationality);
        } else {
            throw new FootourException("The nationality you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteNationality(Integer id) throws FootourException {
        if (nationalityRepository.exists(id)) {
            nationalityRepository.delete(id);
        } else {
            throw new FootourException("The nationality you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
