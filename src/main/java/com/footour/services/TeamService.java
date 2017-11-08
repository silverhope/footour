package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Team;
import com.footour.persistence.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Page<Team> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return teamRepository.findAll(pageRequest);
    }

    public Team getById(Integer id) throws FootourException {
        if (teamRepository.exists(id)) {
            return teamRepository.findOne(id);
        } else {
            throw new FootourException("The team you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Team createTeam(Team team) {
        //Checks for validation of player info
        return teamRepository.save(team);
    }

    public Team updateTeam(Integer id, Team team) throws FootourException {
        if (teamRepository.exists(id)) {
            return teamRepository.save(team);
        } else {
            throw new FootourException("The team you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteTeam(Integer id) throws FootourException {
        if (teamRepository.exists(id)) {
            teamRepository.delete(id);
        } else {
            throw new FootourException("The team you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
