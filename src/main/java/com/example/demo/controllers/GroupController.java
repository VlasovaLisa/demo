package com.example.demo.controllers;
import com.example.demo.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.repositories.GroupRepository;
import com.example.demo.models.Group;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public String getAllGroups(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "groups";
    }

    @GetMapping("/new")
    public String createGroupForm(Model model) {
        model.addAttribute("group", new Group());
        return "groups-new";
    }

    @PostMapping("/save")
    public String saveGroup(@ModelAttribute Group group) {
        groupService.addGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/edit/{id}")
    public String editGroupForm(@PathVariable Long id, Model model) {
        Group group = groupService.getGroupById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid group Id: " + id));
        model.addAttribute("group", group);
        return "groups-edit";
    }

    @PostMapping("/update/{id}")
    public String updateGroup(@PathVariable Long id, @ModelAttribute Group groupDetails) {
        groupService.updateGroup(id, groupDetails);
        return "redirect:/groups";
    }

    @PostMapping("/delete/{id}")
    public String deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return "redirect:/groups";
    }

//    @GetMapping
//    public String getGroups(Model model) {
//        List<Group> groups = groupService.getAllGroups();
//        System.out.println("Loaded groups: " + groups);
//        model.addAttribute("groups", groups);
//        return "groups";
//    }

//    @Autowired
//    private GroupRepository groupRepository;
//
//    @GetMapping
//    public List<Group> getAllGroups() {
//        return groupRepository.findAll();
//    }


}
