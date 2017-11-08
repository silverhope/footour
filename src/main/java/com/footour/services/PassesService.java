package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Passes;
import com.footour.persistence.repositories.PassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassesService {

    @Autowired 
    private PassesRepository passesRepository;

    public List<Passes> getAllPasses() {
        return passesRepository.findAll();
    }

    public Page<Passes> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return passesRepository.findAll(pageRequest);
    }

    public Passes getById(Long id) throws FootourException {
        if (passesRepository.exists(id)) {
            return passesRepository.findOne(id);
        } else {
            throw new FootourException("The passes you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Passes createPasses(Passes passes) {
        //Checks for validation of player info
        return passesRepository.save(passes);
    }

    public Passes updatePasses(Long id, Passes passes) throws FootourException {
        if (passesRepository.exists(id)) {
            return passesRepository.save(passes);
        } else {
            throw new FootourException("The passes you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deletePasses(Long id) throws FootourException {
        if (passesRepository.exists(id)) {
            passesRepository.delete(id);
        } else {
            throw new FootourException("The passes you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
