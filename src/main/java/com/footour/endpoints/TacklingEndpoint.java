package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Tackling;
import com.footour.services.TacklingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "tackling", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TacklingEndpoint {
    @Autowired
    private TacklingService tacklingService;

    @GetMapping
    public List<Tackling> getAllTacklings() {
        return tacklingService.getAllTacklings();
    }

    @GetMapping("/page")
    public Page<Tackling> pageTacklings(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return tacklingService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Tackling getById(@PathVariable("id") Long id) throws FootourException {
        return tacklingService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tackling createTackling(@RequestBody Tackling tackling) throws FootourException {
        return tacklingService.createTackling(tackling);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tackling editTackling(@PathVariable("id") Long id, @RequestBody Tackling tackling) throws FootourException {
        return tacklingService.updateTackling(id, tackling);
    }

    @DeleteMapping("/{id}")
    public void deleteTackling(@PathVariable("id") Long id) throws FootourException {
        tacklingService.deleteTackling(id);
    }
}
