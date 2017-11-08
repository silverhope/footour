package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Championship;
import com.footour.persistence.repositories.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionshipService {

    @Autowired
    private ChampionshipRepository championshipRepository;

    public List<Championship> getAllChampionships() {
        return championshipRepository.findAll();
    }

    public Page<Championship> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return championshipRepository.findAll(pageRequest);
    }

    public Championship getById(Integer id) throws FootourException {
        if (championshipRepository.exists(id)) {
            return championshipRepository.findOne(id);
        } else {
            throw new FootourException("The championship you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Championship createChampionship(Championship championship) {
        //Checks for validation of player info
        return championshipRepository.save(championship);
    }

    public Championship updateChampionship(Integer id, Championship championship) throws FootourException {
        if (championshipRepository.exists(id)) {
            return championshipRepository.save(championship);
        } else {
            throw new FootourException("The championship you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteChampionship(Integer id) throws FootourException {
        if (championshipRepository.exists(id)) {
            championshipRepository.delete(id);
        } else {
            throw new FootourException("The championship you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
