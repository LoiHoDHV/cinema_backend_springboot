package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT cate.category_id from tbl_categories cate WHERE cate.category_name = :name", nativeQuery = true)
    public Long findIdByName(@Param("name") String name);

    public Category findCategoryByCategoryName(String name);
}
