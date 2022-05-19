package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    @Query(value = "select * from blog where blog_name like :name",nativeQuery = true)
//    List<Blog> searchByName(@Param("name") String name);
//    Page<Blog> findAllByBlogNameContaining(String name, Pageable pageable);

    @Query(value = "select * from blog where blog_name like :name",
    countQuery = "select * from blog where blog_name like :name",nativeQuery = true)
    Page<Blog> findAllByName(@Param("name") String name, Pageable pageable);
}
