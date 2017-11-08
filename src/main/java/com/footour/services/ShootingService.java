package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Shooting;
import com.footour.persistence.repositories.ShootingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShootingService {
    
    @Autowired
    private ShootingRepository shootingRepository;

    public List<Shooting> getAllShootings() {
        return shootingRepository.findAll();
    }

    public Page<Shooting> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return shootingRepository.findAll(pageRequest);
    }

    public Shooting getById(Long id) throws FootourException {
        if (shootingRepository.exists(id)) {
            return shootingRepository.findOne(id);
        } else {
            throw new FootourException("The shooting you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Shooting createShooting(Shooting shooting) {
        //Checks for validation of player info
        return shootingRepository.save(shooting);
    }

    public Shooting updateShooting(Long id, Shooting shooting) throws FootourException {
        if (shootingRepository.exists(id)) {
            return shootingRepository.save(shooting);
        } else {
            throw new FootourException("The shooting you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteShooting(Long id) throws FootourException {
        if (shootingRepository.exists(id)) {
            shootingRepository.delete(id);
        } else {
            throw new FootourException("The shooting you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }

    }
}
