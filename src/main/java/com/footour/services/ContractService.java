package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Contract;
import com.footour.persistence.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public Page<Contract> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return contractRepository.findAll(pageRequest);
    }

    public Contract getById(Integer id) throws FootourException {
        if (contractRepository.exists(id)) {
            return contractRepository.findOne(id);
        } else {
            throw new FootourException("The contract you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Contract createContract(Contract contract) {
        //Checks for validation of player info
        return contractRepository.save(contract);
    }

    public Contract updateContract(Integer id, Contract contract) throws FootourException {
        if (contractRepository.exists(id)) {
            return contractRepository.save(contract);
        } else {
            throw new FootourException("The contract you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteContract(Integer id) throws FootourException {
        if (contractRepository.exists(id)) {
            contractRepository.delete(id);
        } else {
            throw new FootourException("The contract you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
