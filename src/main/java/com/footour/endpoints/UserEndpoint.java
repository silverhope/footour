package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.User;
import com.footour.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserEndpoint {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/page")
    public Page<User> pageUsers(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return userService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) throws FootourException {
        return userService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User createUser(@RequestBody User user) throws FootourException {
        return userService.createUser(user);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User editUser(@PathVariable("id") Long id, @RequestBody User user) throws FootourException {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws FootourException {
        userService.deleteUser(id);
    }
}
