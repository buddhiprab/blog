package com.buddhi.blog.repositories;

import com.buddhi.blog.models.Comment;
import com.buddhi.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long id);

    @Transactional
    @Modifying
    @Query("delete FROM Comment o WHERE o.postId = :postId and o.id = :id")
    void deleteComment(@Param("postId") Long postId, @Param("id") Long id);
}
