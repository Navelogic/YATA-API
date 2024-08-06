package br.com.yata.artifact.Service;

import br.com.yata.artifact.Model.Group.Group;
import br.com.yata.artifact.Model.Group.GroupDTO;
import br.com.yata.artifact.Model.Group.GroupSingularDTO;
import br.com.yata.artifact.Model.Task.TaskDTO;
import br.com.yata.artifact.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Transactional(readOnly = true)
    public Long count() {
        return groupRepository.count();
    }

    @Transactional(readOnly = true)
    public List<GroupDTO> findAll(){
        return groupRepository.findAll().stream()
                .map(group -> new GroupDTO(group.getId(), group.getName(), group.getDescription()))
                .collect(java.util.stream.Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GroupSingularDTO findById(Long id){
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found with id: " + id));

        List<TaskDTO> tasks = group.getTasks().stream()
                .map(task -> new TaskDTO(task.getId(), task.getName(), task.getDescription()))
                .collect(java.util.stream.Collectors.toList());

        return new GroupSingularDTO(
                group.getId(),
                group.getName(),
                group.getDescription(),
                tasks
        );
    }

    @Transactional
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Transactional
    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }
    @Transactional
    public void deleteAll() {
        groupRepository.deleteAll();
    }

}
