package com.ecommerce.ecommerce.DTOs;

import com.ecommerce.ecommerce.Models.Product;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private String userName;
    private String comment;
    private Integer productID;
}
