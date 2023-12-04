package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {
}
