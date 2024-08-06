package br.com.yata.artifact.Controller;

import br.com.yata.artifact.Model.Category.Category;
import br.com.yata.artifact.Model.Category.CategoryDTO;
import br.com.yata.artifact.Model.Category.CategorySingularDTO;
import br.com.yata.artifact.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/count")
    public Long count() {
        return categoryService.count();
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public CategorySingularDTO findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<CategorySingularDTO> save(@RequestBody Category category){
        Category category1 = categoryService.save(category);
        CategorySingularDTO categorySingularDTO = categoryService.findById(category1.getId());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category1.getId())
                .toUri();

        return ResponseEntity.created(uri).body(categorySingularDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
    @DeleteMapping
    public void deleteAll() {
        categoryService.deleteAll();
    }








}
