package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Nationality;
import com.footour.services.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "nationality", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NationalityEndpoint {
    @Autowired
    private NationalityService nationalityService;

    @GetMapping
    public List<Nationality> getAllNationalities() {
        return nationalityService.getAllNationalities();
    }

    @GetMapping("/page")
    public Page<Nationality> pageNationalities(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return nationalityService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Nationality getById(@PathVariable("id") Integer id) throws FootourException {
        return nationalityService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Nationality createNationality(@RequestBody Nationality nationality) throws FootourException {
        return nationalityService.createNationality(nationality);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Nationality editNationality(@PathVariable("id") Integer id, @RequestBody Nationality nationality) throws FootourException {
        return nationalityService.updateNationality(id, nationality);
    }

    @DeleteMapping("/{id}")
    public void deleteNationality(@PathVariable("id") Integer id) throws FootourException {
        nationalityService.deleteNationality(id);
    }
}
