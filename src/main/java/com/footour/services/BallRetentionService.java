package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.BallRetention;
import com.footour.persistence.repositories.BallRetentionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BallRetentionService {

    @Autowired
    private BallRetentionRepository ballRetentionRepository;

    public List<BallRetention> getAllBallRetentions() {
        return ballRetentionRepository.findAll();
    }

    public Page<BallRetention> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return ballRetentionRepository.findAll(pageRequest);
    }

    public BallRetention getById(Long id) throws FootourException {
        if (ballRetentionRepository.exists(id)) {
            return ballRetentionRepository.findOne(id);
        } else {
            throw new FootourException("The ballRetention you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public BallRetention createBallRetention(BallRetention ballRetention) {
        //Checks for validation of player info
        return ballRetentionRepository.save(ballRetention);
    }

    public BallRetention updateBallRetention(Long id, BallRetention ballRetention) throws FootourException {
        if (ballRetentionRepository.exists(id)) {
            return ballRetentionRepository.save(ballRetention);
        } else {
            throw new FootourException("The ballRetention you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteBallRetention(Long id) throws FootourException {
        if (ballRetentionRepository.exists(id)) {
            ballRetentionRepository.delete(id);
        } else {
            throw new FootourException("The ballRetention you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
