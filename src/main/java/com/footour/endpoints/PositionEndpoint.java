package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Position;
import com.footour.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "position", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PositionEndpoint {
    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/page")
    public Page<Position> pagePositions(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return positionService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Position getById(@PathVariable("id") Integer id) throws FootourException {
        return positionService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Position createPosition(@RequestBody Position position) throws FootourException {
        return positionService.createPosition(position);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Position editPosition(@PathVariable("id") Integer id, @RequestBody Position position) throws FootourException {
        return positionService.updatePosition(id, position);
    }

    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable("id") Integer id) throws FootourException {
        positionService.deletePosition(id);
    }
}
