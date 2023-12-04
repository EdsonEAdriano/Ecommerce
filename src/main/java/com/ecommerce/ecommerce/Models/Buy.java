package com.ecommerce.ecommerce.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_buy")
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date = new Date();
    private String buyer;
    private Double totalPrice;
}
