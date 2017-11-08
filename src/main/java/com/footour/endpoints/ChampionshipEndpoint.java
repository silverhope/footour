package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Championship;
import com.footour.services.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "championship", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ChampionshipEndpoint {

    @Autowired
    private ChampionshipService championshipService;

    @GetMapping
    public List<Championship> getAllChampionships() {
        return championshipService.getAllChampionships();
    }

    @GetMapping("/page")
    public Page<Championship> pageChampionships(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return championshipService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Championship getById(@PathVariable("id") Integer id) throws FootourException {
        return championshipService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Championship createChampionship(@RequestBody Championship championship) throws FootourException {
        return championshipService.createChampionship(championship);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Championship editChampionship(@PathVariable("id") Integer id, @RequestBody Championship championship) throws FootourException {
        return championshipService.updateChampionship(id, championship);
    }

    @DeleteMapping("/{id}")
    public void deleteChampionship(@PathVariable("id") Integer id) throws FootourException {
        championshipService.deleteChampionship(id);
    }
}
