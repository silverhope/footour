package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Contract;
import com.footour.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "contract", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ContractEndpoint {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/page")
    public Page<Contract> pageContracts(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return contractService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Contract getById(@PathVariable("id") Integer id) throws FootourException {
        return contractService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Contract createContract(@RequestBody Contract contract) throws FootourException {
        return contractService.createContract(contract);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Contract editContract(@PathVariable("id") Integer id, @RequestBody Contract contract) throws FootourException {
        return contractService.updateContract(id, contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable("id") Integer id) throws FootourException {
        contractService.deleteContract(id);
    }
}
