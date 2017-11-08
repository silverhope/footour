package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.PositionType;
import com.footour.services.PositionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "positionType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PositionTypeEndpoint {
    @Autowired
    private PositionTypeService positionTypeService;

    @GetMapping
    public List<PositionType> getAllPositionTypes() {
        return positionTypeService.getAllPositionTypes();
    }

    @GetMapping("/page")
    public Page<PositionType> pagePositionTypes(@RequestParam(value = "num", required = true) int num,
                                        @RequestParam(value = "size", required = true) int size,
                                        @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                        @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return positionTypeService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public PositionType getById(@PathVariable("id") Integer id) throws FootourException {
        return positionTypeService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PositionType createPositionType(@RequestBody PositionType positionType) throws FootourException {
        return positionTypeService.createPositionType(positionType);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PositionType editPositionType(@PathVariable("id") Integer id, @RequestBody PositionType positionType) throws FootourException {
        return positionTypeService.updatePositionType(id, positionType);
    }

    @DeleteMapping("/{id}")
    public void deletePositionType(@PathVariable("id") Integer id) throws FootourException {
        positionTypeService.deletePositionType(id);
    }
}
