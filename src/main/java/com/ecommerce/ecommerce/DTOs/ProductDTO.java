package com.ecommerce.ecommerce.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private String description;
    private Integer categoryID;
    private Double price;
    private String evaluation;
}
