package br.com.yata.artifact.Controller;

import br.com.yata.artifact.Model.Group.Group;
import br.com.yata.artifact.Model.Group.GroupDTO;
import br.com.yata.artifact.Model.Group.GroupSingularDTO;
import br.com.yata.artifact.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/count")
    public Long count() {
        return groupService.count();
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> findAll(){
        return ResponseEntity.ok(groupService.findAll());
    }

    @GetMapping("/{id}")
    public GroupSingularDTO findById(@PathVariable Long id) {
        return groupService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<GroupSingularDTO> save(@RequestBody Group group){
        Group group1 = groupService.save(group);
        GroupSingularDTO groupSingularDTO = groupService.findById(group1.getId());

        URI uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(group1.getId())
                .toUri();

        return ResponseEntity.created(uri).body(groupSingularDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        groupService.deleteById(id);
    }
    @DeleteMapping
    public void deleteAll() {
        groupService.deleteAll();
    }
}
