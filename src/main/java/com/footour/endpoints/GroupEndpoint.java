package com.footour.endpoints;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Group;
import com.footour.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GroupEndpoint {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/page")
    public Page<Group> pageGroups(@RequestParam(value = "num", required = true) int num,
                                    @RequestParam(value = "size", required = true) int size,
                                    @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
                                    @RequestParam(value = "direction", defaultValue="asc", required = false) String direction) {
        return groupService.getPage(num, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Group getById(@PathVariable("id") Integer id) throws FootourException {
        return groupService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Group createGroup(@RequestBody Group group) throws FootourException {
        return groupService.createGroup(group);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Group editGroup(@PathVariable("id") Integer id, @RequestBody Group group) throws FootourException {
        return groupService.updateGroup(id, group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") Integer id) throws FootourException {
        groupService.deleteGroup(id);
    }
}
