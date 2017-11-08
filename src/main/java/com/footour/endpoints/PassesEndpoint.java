package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Passes;
import com.footour.services.PassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "passes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PassesEndpoint {
    @Autowired
    private PassesService passesService;

    @GetMapping
    public List<Passes> getAllPasses() {
        return passesService.getAllPasses();
    }

    @GetMapping("/page")
    public Page<Passes> pagePasses(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return passesService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Passes getById(@PathVariable("id") Long id) throws FootourException {
        return passesService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Passes createPasses(@RequestBody Passes passes) throws FootourException {
        return passesService.createPasses(passes);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Passes editPasses(@PathVariable("id") Long id, @RequestBody Passes passes) throws FootourException {
        return passesService.updatePasses(id, passes);
    }

    @DeleteMapping("/{id}")
    public void deletePasses(@PathVariable("id") Long id) throws FootourException {
        passesService.deletePasses(id);
    }
}
