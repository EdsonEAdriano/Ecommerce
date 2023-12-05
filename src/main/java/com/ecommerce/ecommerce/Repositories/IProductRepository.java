package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT prd.* " +
                   "FROM t_product prd " +
                   "INNER JOIN t_category cat " +
                   "ON prd.category_id = cat.id " +
                   "WHERE cat.name = :category", nativeQuery = true)
    List<Product> getByCategory(@Param("category") String category);

    @Query(value = "SELECT * " +
                   "FROM t_product " +
                   "WHERE UPPER(name) LIKE UPPER(CONCAT('%', :name, '%'))", nativeQuery = true)
    List<Product> getByName(@Param("name") String name);

    @Query(value = "SELECT prd.* " +
                   "FROM t_product prd " +
                   "INNER JOIN t_category cat " +
                   "ON prd.category_id = cat.id " +
                   "WHERE cat.name = :category " +
                   "AND UPPER(prd.name) LIKE UPPER(CONCAT('%', :name, '%'))", nativeQuery = true)
    List<Product> getByCategoryAndName(@Param("category") String category, @Param("name") String name);
}
