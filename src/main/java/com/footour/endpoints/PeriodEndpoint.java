package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Period;
import com.footour.services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "period", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PeriodEndpoint {
    @Autowired
    private PeriodService periodService;

    @GetMapping
    public List<Period> getAllPeriods() {
        return periodService.getAllPeriods();
    }

    @GetMapping("/page")
    public Page<Period> pagePeriods(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return periodService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Period getById(@PathVariable("id") Integer id) throws FootourException {
        return periodService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Period createPeriod(@RequestBody Period period) throws FootourException {
        return periodService.createPeriod(period);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Period editPeriod(@PathVariable("id") Integer id, @RequestBody Period period) throws FootourException {
        return periodService.updatePeriod(id, period);
    }

    @DeleteMapping("/{id}")
    public void deletePeriod(@PathVariable("id") Integer id) throws FootourException {
        periodService.deletePeriod(id);
    }
}
