package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Movement;
import com.footour.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "movement", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovementEndpoint {
    @Autowired
    private MovementService movementService;

    @GetMapping
    public List<Movement> getAllMovements() {
        return movementService.getAllMovements();
    }

    @GetMapping("/page")
    public Page<Movement> pageMovements(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return movementService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Movement getById(@PathVariable("id") Long id) throws FootourException {
        return movementService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movement createMovement(@RequestBody Movement movement) throws FootourException {
        return movementService.createMovement(movement);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movement editMovement(@PathVariable("id") Long id, @RequestBody Movement movement) throws FootourException {
        return movementService.updateMovement(id, movement);
    }

    @DeleteMapping("/{id}")
    public void deleteMovement(@PathVariable("id") Long id) throws FootourException {
        movementService.deleteMovement(id);
    }
}
