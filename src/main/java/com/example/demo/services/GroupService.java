package com.example.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.*;
import com.example.demo.repositories.GroupRepository;

@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    @Transactional(readOnly = true)
    public List<Group> getAllGroups() {
        return groupRepository.findAll(Sort.by("name"));
    }

    @Transactional(readOnly = true)
    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    @Transactional
    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    @Transactional
    public void addNewGroup(String name, Integer debutYear, String company) {
        Group group = new Group();
        group.setName(name);
        group.setDebutYear(debutYear);
        group.setCompany(company);
        groupRepository.save(group);
    }

    @Transactional
    public void updateGroup(Long id, Group groupDetails) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid group Id: " + id));
        group.setName(groupDetails.getName());
        group.setDebutYear(groupDetails.getDebutYear());
        group.setCompany(groupDetails.getCompany());
        groupRepository.save(group);
    }

    @Transactional
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
