/*
 * Copyright (c) 2017.
 */

package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.PlayerPosition;
import com.footour.services.PlayerPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "playerPosition", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PlayerPositionEndpoint {

    @Autowired
    private PlayerPositionService playerPositionService;

    @GetMapping
    public List<PlayerPosition> getAllPositions() {
        return playerPositionService.getAllPositions();
    }

    @GetMapping("/page")
    public Page<PlayerPosition> pagePositions(@RequestParam(value = "num", required = true) int num,
                                        @RequestParam(value = "size", required = true) int size,
                                        @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                        @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return playerPositionService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public PlayerPosition getById(@PathVariable("id") Long id) throws FootourException {
        return playerPositionService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PlayerPosition createPosition(@RequestBody PlayerPosition playerPosition) throws FootourException {
        return playerPositionService.createPosition(playerPosition);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PlayerPosition editPosition(@PathVariable("id") Long id, @RequestBody PlayerPosition playerPosition) throws FootourException {
        return playerPositionService.updatePosition(id, playerPosition);
    }

    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable("id") Long id) throws FootourException {
        playerPositionService.deletePosition(id);
    }
}
