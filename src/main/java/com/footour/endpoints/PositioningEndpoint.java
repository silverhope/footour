package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Positioning;
import com.footour.services.PositioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "positioning", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PositioningEndpoint {
    @Autowired
    private PositioningService positioningService;

    @GetMapping
    public List<Positioning> getAllPositionings() {
        return positioningService.getAllPositionings();
    }

    @GetMapping("/page")
    public Page<Positioning> pagePositionings(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return positioningService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Positioning getById(@PathVariable("id") Long id) throws FootourException {
        return positioningService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Positioning createPositioning(@RequestBody Positioning positioning) throws FootourException {
        return positioningService.createPositioning(positioning);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Positioning editPositioning(@PathVariable("id") Long id, @RequestBody Positioning positioning) throws FootourException {
        return positioningService.updatePositioning(id, positioning);
    }

    @DeleteMapping("/{id}")
    public void deletePositioning(@PathVariable("id") Long id) throws FootourException {
        positioningService.deletePositioning(id);
    }
}
