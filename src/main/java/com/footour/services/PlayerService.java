package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Player;
import com.footour.persistence.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Page<Player> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Order(sortDirection, sortBy)));
        return playerRepository.findAll(pageRequest);
    }

    public Player getById(Long id) throws FootourException {
        if (playerRepository.exists(id)) {
            return playerRepository.findOne(id);
        } else {
            throw new FootourException("The player you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Player createPlayer(Player player) {
        //Checks for validation of player info
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player player) throws FootourException {
        if (playerRepository.exists(id)) {
            return playerRepository.save(player);
        } else {
            throw new FootourException("The player you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deletePlayer(Long id) throws FootourException {
        if (playerRepository.exists(id)) {
            playerRepository.delete(id);
        } else {
            throw new FootourException("The player you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
