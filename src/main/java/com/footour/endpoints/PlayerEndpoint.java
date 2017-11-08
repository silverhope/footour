package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Player;
import com.footour.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "player", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PlayerEndpoint {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/page")
    public Page<Player> pagePlayers(@RequestParam(value = "num", required = true) int num,
    @RequestParam(value = "size", required = true) int size,
    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return playerService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable("id") Long id) throws FootourException {
        return playerService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Player createPlayer(@RequestBody Player player) throws FootourException {
        return playerService.createPlayer(player);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Player editPlayer(@PathVariable("id") Long id, @RequestBody Player player) throws FootourException {
        return playerService.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable("id") Long id) throws FootourException {
        playerService.deletePlayer(id);
    }
}
