package com.sterlit.dvd.controller;


import com.sterlit.dvd.entity.Category;
import com.sterlit.dvd.repo.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    @GetMapping("/get/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Категория с указаным ID %d не найден", id)));
    }

    @GetMapping("/getbyname")
    public Category getCategoryByName(@RequestParam(name = "name") String name) {
        return categoryRepository.findByName(name);
    }
}
