package com.ecommerce.ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Double price;
    private String evaluation;
    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Image> images;
    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Comment> comments;
}
