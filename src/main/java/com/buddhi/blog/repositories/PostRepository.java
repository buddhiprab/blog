package com.buddhi.blog.repositories;

import com.buddhi.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT o FROM Post o WHERE o.title like %:text%")
    List<Post> search(@Param("text") String text);

    List<Post> findByTitleContaining(String text);
}
