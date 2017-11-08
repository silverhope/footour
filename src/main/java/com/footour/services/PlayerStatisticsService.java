package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.PlayerStatistics;
import com.footour.persistence.repositories.PlayerStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerStatisticsService {
    
    @Autowired
    private PlayerStatisticsRepository playerStatisticsRepository;

    public List<PlayerStatistics> getAllPlayerStatistics() {
        return playerStatisticsRepository.findAll();
    }

    public Page<PlayerStatistics> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return playerStatisticsRepository.findAll(pageRequest);
    }

    public PlayerStatistics getById(Long id) throws FootourException {
        if (playerStatisticsRepository.exists(id)) {
            return playerStatisticsRepository.findOne(id);
        } else {
            throw new FootourException("The playerStatistics you requested do not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public PlayerStatistics createPlayerStatistics(PlayerStatistics playerStatistics) {
        //Checks for validation of player info
        return playerStatisticsRepository.save(playerStatistics);
    }

    public PlayerStatistics updatePlayerStatistics(Long id, PlayerStatistics playerStatistics) throws FootourException {
        if (playerStatisticsRepository.exists(id)) {
            return playerStatisticsRepository.save(playerStatistics);
        } else {
            throw new FootourException("The playerStatistics you are trying to update do not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deletePlayerStatistics(Long id) throws FootourException {
        if (playerStatisticsRepository.exists(id)) {
            playerStatisticsRepository.delete(id);
        } else {
            throw new FootourException("The playerStatistics you are trying to delete do not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
