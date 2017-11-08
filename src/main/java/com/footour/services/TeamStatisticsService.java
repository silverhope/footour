package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.TeamStatistics;
import com.footour.persistence.repositories.TeamStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamStatisticsService {

    @Autowired
    private TeamStatisticsRepository teamStatisticsRepository;

    public List<TeamStatistics> getAllTeamStatistics() {
        return teamStatisticsRepository.findAll();
    }

    public Page<TeamStatistics> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return teamStatisticsRepository.findAll(pageRequest);
    }

    public TeamStatistics getById(Integer id) throws FootourException {
        if (teamStatisticsRepository.exists(id)) {
            return teamStatisticsRepository.findOne(id);
        } else {
            throw new FootourException("The teamStatistics you requested do not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public TeamStatistics createTeamStatistics(TeamStatistics teamStatistics) {
        //Checks for validation of player info
        return teamStatisticsRepository.save(teamStatistics);
    }

    public TeamStatistics updateTeamStatistics(Integer id, TeamStatistics teamStatistics) throws FootourException {
        if (teamStatisticsRepository.exists(id)) {
            return teamStatisticsRepository.save(teamStatistics);
        } else {
            throw new FootourException("The teamStatistics you are trying to update do not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteTeamStatistics(Integer id) throws FootourException {
        if (teamStatisticsRepository.exists(id)) {
            teamStatisticsRepository.delete(id);
        } else {
            throw new FootourException("The teamStatistics you are trying to delete do not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
