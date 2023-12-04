package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Integer> {
}
