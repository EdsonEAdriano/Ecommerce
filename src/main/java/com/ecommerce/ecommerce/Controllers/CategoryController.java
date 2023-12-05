package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Models.Category;
import com.ecommerce.ecommerce.Repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {
    @Autowired
    private ICategoryRepository _categoryRepository;

    @PostMapping
    public Category post(@RequestBody Category category){
        return _categoryRepository.save(category);
    }

    @GetMapping
    public Iterable<Category> get(){
        return _categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable int id){
        return _categoryRepository.findById(id).orElse(null);
    }

    @PutMapping
    public Category put(@RequestBody Category category){
        if(_categoryRepository.existsById(category.getId())){
            return _categoryRepository.save(category);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        _categoryRepository.deleteById(id);
    }
}
