package com.movieflix.movieflix.Repository;

import com.movieflix.movieflix.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
