package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Match;
import com.footour.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "match", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MatchEndpoint {
    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<Match> getAllMatchs() {
        return matchService.getAllMatches();
    }

    @GetMapping("/page")
    public Page<Match> pageMatches(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return matchService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Match getById(@PathVariable("id") Long id) throws FootourException {
        return matchService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Match createMatch(@RequestBody Match match) throws FootourException {
        return matchService.createMatch(match);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Match editMatch(@PathVariable("id") Long id, @RequestBody Match match) throws FootourException {
        return matchService.updateMatch(id, match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable("id") Long id) throws FootourException {
        matchService.deleteMatch(id);
    }
}
