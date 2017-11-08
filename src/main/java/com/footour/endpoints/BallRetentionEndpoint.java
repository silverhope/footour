package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.BallRetention;
import com.footour.services.BallRetentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "ballRetention", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BallRetentionEndpoint {

    @Autowired
    private BallRetentionService ballRetentionService;

    @GetMapping
    public List<BallRetention> getAllBallRetentions() {
        return ballRetentionService.getAllBallRetentions();
    }

    @GetMapping("/page")
    public Page<BallRetention> pageBallRetentions(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return ballRetentionService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public BallRetention getById(@PathVariable("id") Long id) throws FootourException {
        return ballRetentionService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BallRetention createBallRetention(@RequestBody BallRetention ballRetention) throws FootourException {
        return ballRetentionService.createBallRetention(ballRetention);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BallRetention editBallRetention(@PathVariable("id") Long id, @RequestBody BallRetention ballRetention) throws FootourException {
        return ballRetentionService.updateBallRetention(id, ballRetention);
    }

    @DeleteMapping("/{id}")
    public void deleteBallRetention(@PathVariable("id") Long id) throws FootourException {
        ballRetentionService.deleteBallRetention(id);
    }
}
