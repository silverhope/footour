package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.PlayerStatistics;
import com.footour.services.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "playerStatistics", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PlayerStatisticsEndpoint {

    @Autowired
    private PlayerStatisticsService playerStatisticsService;

    @GetMapping
    public List<PlayerStatistics> getAllPlayerStatistics() {
        return playerStatisticsService.getAllPlayerStatistics();
    }

    @GetMapping("/page")
    public Page<PlayerStatistics> pagePlayerStatistics(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return playerStatisticsService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public PlayerStatistics getById(@PathVariable("id") Long id) throws FootourException {
        return playerStatisticsService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PlayerStatistics createPlayerStatistics(@RequestBody PlayerStatistics playerStatistics) throws FootourException {
        return playerStatisticsService.createPlayerStatistics(playerStatistics);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PlayerStatistics editPlayerStatistics(@PathVariable("id") Long id, @RequestBody PlayerStatistics playerStatistics) throws FootourException {
        return playerStatisticsService.updatePlayerStatistics(id, playerStatistics);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerStatistics(@PathVariable("id") Long id) throws FootourException {
        playerStatisticsService.deletePlayerStatistics(id);
    }
}
