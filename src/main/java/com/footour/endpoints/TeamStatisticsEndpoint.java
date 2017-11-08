package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.TeamStatistics;
import com.footour.services.TeamStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "teamStatistics", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TeamStatisticsEndpoint {
    @Autowired
    private TeamStatisticsService teamStatisticsService;

    @GetMapping
    public List<TeamStatistics> getAllTeamStatistics() {
        return teamStatisticsService.getAllTeamStatistics();
    }

    @GetMapping("/page")
    public Page<TeamStatistics> pageTeamStatisticss(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return teamStatisticsService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public TeamStatistics getById(@PathVariable("id") Integer id) throws FootourException {
        return teamStatisticsService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TeamStatistics createTeamStatistics(@RequestBody TeamStatistics teamStatistics) throws FootourException {
        return teamStatisticsService.createTeamStatistics(teamStatistics);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TeamStatistics editTeamStatistics(@PathVariable("id") Integer id, @RequestBody TeamStatistics teamStatistics) throws FootourException {
        return teamStatisticsService.updateTeamStatistics(id, teamStatistics);
    }

    @DeleteMapping("/{id}")
    public void deleteTeamStatistics(@PathVariable("id") Integer id) throws FootourException {
        teamStatisticsService.deleteTeamStatistics(id);
    }
}
