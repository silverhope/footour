package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Season;
import com.footour.persistence.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {
    
    @Autowired
    private SeasonRepository seasonRepository;

    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    public Page<Season> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return seasonRepository.findAll(pageRequest);
    }

    public Season getById(Integer id) throws FootourException {
        if (seasonRepository.exists(id)) {
            return seasonRepository.findOne(id);
        } else {
            throw new FootourException("The season you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Season createSeason(Season season) {
        //Checks for validation of player info
        return seasonRepository.save(season);
    }

    public Season updateSeason(Integer id, Season season) throws FootourException {
        if (seasonRepository.exists(id)) {
            return seasonRepository.save(season);
        } else {
            throw new FootourException("The season you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteSeason(Integer id) throws FootourException {
        if (seasonRepository.exists(id)) {
            seasonRepository.delete(id);
        } else {
            throw new FootourException("The season you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
