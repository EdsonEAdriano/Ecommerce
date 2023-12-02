package com.ecommerce.ecommerce.Repositories;


import com.ecommerce.ecommerce.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {}