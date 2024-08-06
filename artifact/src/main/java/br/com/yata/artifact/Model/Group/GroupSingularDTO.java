package br.com.yata.artifact.Model.Group;

import br.com.yata.artifact.Model.Task.TaskDTO;

import java.util.List;

public record GroupSingularDTO(
        Long id,
        String name,
        String description,
        List<TaskDTO> tasks
) {
}
