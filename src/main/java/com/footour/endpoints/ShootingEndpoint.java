package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Shooting;
import com.footour.services.ShootingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "shooting", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ShootingEndpoint {
    @Autowired
    private ShootingService shootingService;

    @GetMapping
    public List<Shooting> getAllShootings() {
        return shootingService.getAllShootings();
    }

    @GetMapping("/page")
    public Page<Shooting> pageShootings(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return shootingService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Shooting getById(@PathVariable("id") Long id) throws FootourException {
        return shootingService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Shooting createShooting(@RequestBody Shooting shooting) throws FootourException {
        return shootingService.createShooting(shooting);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Shooting editShooting(@PathVariable("id") Long id, @RequestBody Shooting shooting) throws FootourException {
        return shootingService.updateShooting(id, shooting);
    }

    @DeleteMapping("/{id}")
    public void deleteShooting(@PathVariable("id") Long id) throws FootourException {
        shootingService.deleteShooting(id);
    }
}
