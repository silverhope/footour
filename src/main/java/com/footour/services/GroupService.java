package com.footour.services;

import com.footour.exceptions.FootourException;
import com.footour.persistence.entities.Group;
import com.footour.persistence.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Page<Group> getPage(int num, int size, String sortBy, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = new PageRequest(num, size, new Sort(new Sort.Order(sortDirection, sortBy)));
        return groupRepository.findAll(pageRequest);
    }

    public Group getById(Integer id) throws FootourException {
        if (groupRepository.exists(id)) {
            return groupRepository.findOne(id);
        } else {
            throw new FootourException("The group you requested does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public Group createGroup(Group group) {
        //Checks for validation of player info
        return groupRepository.save(group);
    }

    public Group updateGroup(Integer id, Group group) throws FootourException {
        if (groupRepository.exists(id)) {
            return groupRepository.save(group);
        } else {
            throw new FootourException("The group you are trying to update does not exist!", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteGroup(Integer id) throws FootourException {
        if (groupRepository.exists(id)) {
            groupRepository.delete(id);
        } else {
            throw new FootourException("The group you are trying to delete does not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
