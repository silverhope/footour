package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Match;
import com.footour.persistence.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Page<Match> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return matchRepository.findAll(pageRequest);
    }

    public Match getById(Long id) throws FootourException {
        if (matchRepository.exists(id)) {
            return matchRepository.findOne(id);
        } else {
            throw new FootourException("The match you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Match createMatch(Match match) {
        //Checks for validation of player info
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match match) throws FootourException {
        if (matchRepository.exists(id)) {
            return matchRepository.save(match);
        } else {
            throw new FootourException("The match you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteMatch(Long id) throws FootourException {
        if (matchRepository.exists(id)) {
            matchRepository.delete(id);
        } else {
            throw new FootourException("The match you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
