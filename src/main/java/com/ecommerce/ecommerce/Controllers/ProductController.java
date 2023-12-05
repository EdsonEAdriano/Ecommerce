package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.DTOs.ProductDTO;
import com.ecommerce.ecommerce.Models.Category;
import com.ecommerce.ecommerce.Models.Product;
import com.ecommerce.ecommerce.Repositories.ICategoryRepository;
import com.ecommerce.ecommerce.Repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    @Autowired
    private IProductRepository _productRepository;
    @Autowired
    private ICategoryRepository _categoryRepository;

    @PostMapping
    public Product post(@RequestBody ProductDTO productDTO){
        Category category = _categoryRepository.findById(productDTO.getCategoryID()).orElse(null);

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        product.setPrice(productDTO.getPrice());
        product.setEvaluation(productDTO.getEvaluation());


        return _productRepository.save(product);
    }

    @GetMapping
    public Iterable<Product> get(@RequestParam(name = "name", required = false) String name){
        if (name == null){
            return _productRepository.findAll();
        }
        else {
            return _productRepository.getByName(name);
        }
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable int id){
        return _productRepository.findById(id).orElse(null);
    }

    @GetMapping("/category/{category}")
    public Iterable<Product> getByCategory(@PathVariable String category, @RequestParam(name = "name", required = false) String name){
        if (name == null) {
            return _productRepository.getByCategory(category);
        }
        else {
            return _productRepository.getByCategoryAndName(category, name);
        }
    }


    @PutMapping("/{id}")
    public Product put(@PathVariable int id, @RequestBody ProductDTO productDTO){
        Category category = _categoryRepository.findById(productDTO.getCategoryID()).orElse(null);

        Product product = new Product();
        product.setId(id);
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        product.setPrice(productDTO.getPrice());
        product.setEvaluation(productDTO.getEvaluation());


        return _productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        _productRepository.deleteById(id);
    }
}
