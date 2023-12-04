package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item, Integer> {
}
