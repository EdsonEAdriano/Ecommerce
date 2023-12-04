package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
