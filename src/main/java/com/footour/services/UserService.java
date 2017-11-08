package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.User;
import com.footour.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Page<User> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return userRepository.findAll(pageRequest);
    }

    public User getById(Long id) throws FootourException {
        if (userRepository.exists(id)) {
            return userRepository.findOne(id);
        } else {
            throw new FootourException("The user you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public User createUser(User user) {
        //Checks for validation of player info
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) throws FootourException {
        if (userRepository.exists(id)) {
            return userRepository.save(user);
        } else {
            throw new FootourException("The user you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteUser(Long id) throws FootourException {
        if (userRepository.exists(id)) {
            userRepository.delete(id);
        } else {
            throw new FootourException("The user you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
