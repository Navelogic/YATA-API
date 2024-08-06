package br.com.yata.artifact.Service;

import br.com.yata.artifact.Model.Category.Category;
import br.com.yata.artifact.Model.Category.CategoryDTO;
import br.com.yata.artifact.Model.Category.CategorySingularDTO;
import br.com.yata.artifact.Model.Task.TaskDTO;
import br.com.yata.artifact.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Long count() {
        return categoryRepository.count();
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName(), category.getDescription()))
                .collect(java.util.stream.Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategorySingularDTO findById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        List<TaskDTO> tasks = category.getTasks().stream()
                .map(task -> new TaskDTO(task.getId(), task.getName(), task.getDescription()))
                .collect(Collectors.toList());

        return new CategorySingularDTO(
                category.getId(),
                category.getName(),
                category.getDescription(),
                tasks
        );
    }

    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
    @Transactional
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Transactional
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

}
