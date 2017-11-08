package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Team;
import com.footour.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "team", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TeamEndpoint {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/page")
    public Page<Team> pageTeams(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return teamService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable("id") Integer id) throws FootourException {
        return teamService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Team createTeam(@RequestBody Team team) throws FootourException {
        return teamService.createTeam(team);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Team editTeam(@PathVariable("id") Integer id, @RequestBody Team team) throws FootourException {
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable("id") Integer id) throws FootourException {
        teamService.deleteTeam(id);
    }
}
