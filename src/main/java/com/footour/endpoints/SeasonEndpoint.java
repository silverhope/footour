package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Season;
import com.footour.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "season", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SeasonEndpoint {
    @Autowired
    private SeasonService seasonService;

    @GetMapping
    public List<Season> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    @GetMapping("/page")
    public Page<Season> pageSeasons(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return seasonService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Season getById(@PathVariable("id") Integer id) throws FootourException {
        return seasonService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Season createSeason(@RequestBody Season season) throws FootourException {
        return seasonService.createSeason(season);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Season editSeason(@PathVariable("id") Integer id, @RequestBody Season season) throws FootourException {
        return seasonService.updateSeason(id, season);
    }

    @DeleteMapping("/{id}")
    public void deleteSeason(@PathVariable("id") Integer id) throws FootourException {
        seasonService.deleteSeason(id);
    }
}
