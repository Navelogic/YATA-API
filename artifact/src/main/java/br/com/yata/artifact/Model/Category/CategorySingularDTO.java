package br.com.yata.artifact.Model.Category;

import br.com.yata.artifact.Model.Task.TaskDTO;

import java.util.List;

public record CategorySingularDTO(Long id,
                                  String name,
                                  String description,
                                  List<TaskDTO> tasks
                                  ) {
}
