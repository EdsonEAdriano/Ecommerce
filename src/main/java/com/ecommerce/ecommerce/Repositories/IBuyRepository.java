package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Models.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBuyRepository extends JpaRepository<Buy, Integer> {
}
