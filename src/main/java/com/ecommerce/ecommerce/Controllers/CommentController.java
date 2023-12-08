package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.DTOs.CommentDTO;
import com.ecommerce.ecommerce.DTOs.ProductDTO;
import com.ecommerce.ecommerce.Models.Category;
import com.ecommerce.ecommerce.Models.Comment;
import com.ecommerce.ecommerce.Models.Product;
import com.ecommerce.ecommerce.Repositories.ICategoryRepository;
import com.ecommerce.ecommerce.Repositories.ICommentRepository;
import com.ecommerce.ecommerce.Repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:5173")
public class CommentController {
    @Autowired
    private ICommentRepository _commentRepository;
    @Autowired
    private IProductRepository _productRepository;

    @PostMapping
    public Comment post(@RequestBody CommentDTO commentDTO){
        Product product = _productRepository.findById(commentDTO.getProductID()).orElse(null);

        Comment comment = new Comment();
        comment.setUserName(commentDTO.getUserName());
        comment.setComment(commentDTO.getComment());
        comment.setProduct(product);


        return _commentRepository.save(comment);
    }

    @GetMapping
    public Iterable<Comment> get(){
        return _commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comment get(@PathVariable int id){
        return _commentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Comment put(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        Product product = _productRepository.findById(commentDTO.getProductID()).orElse(null);

        Comment comment = new Comment();
        comment.setId(id);
        comment.setUserName(commentDTO.getUserName());
        comment.setComment(commentDTO.getComment());
        comment.setProduct(product);


        return _commentRepository.save(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        _commentRepository.deleteById(id);
    }
}
