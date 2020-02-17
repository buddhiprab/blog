package com.buddhi.blog.repositories;

import com.buddhi.blog.models.Comment;
import com.buddhi.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
