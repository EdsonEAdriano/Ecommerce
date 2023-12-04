package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.DTOs.ImageDTO;
import com.ecommerce.ecommerce.Models.Image;
import com.ecommerce.ecommerce.Models.Product;
import com.ecommerce.ecommerce.Repositories.IImageRepository;
import com.ecommerce.ecommerce.Repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private IImageRepository _imageRepository;
    @Autowired
    private IProductRepository _productRepository;

    @PostMapping
    public Image post(@RequestBody ImageDTO imageDTO){
        Product product = _productRepository.findById(imageDTO.getProductID()).orElse(null);

        Image image = new Image();
        image.setSequence(imageDTO.getSequence());
        image.setUrl(imageDTO.getUrl());
        image.setProduct(product);


        return _imageRepository.save(image);
    }

    @GetMapping
    public Iterable<Image> get(){
        return _imageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Image get(@PathVariable int id){
        return _imageRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Image put(@PathVariable Integer id, @RequestBody ImageDTO imageDTO){
        Product product = _productRepository.findById(imageDTO.getProductID()).orElse(null);

        Image image = new Image();
        image.setId(id);
        image.setSequence(imageDTO.getSequence());
        image.setUrl(imageDTO.getUrl());
        image.setProduct(product);


        return _imageRepository.save(image);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        _imageRepository.deleteById(id);
    }
}
