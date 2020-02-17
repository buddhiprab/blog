package com.buddhi.blog.services;

import com.buddhi.blog.dto.PostDto;
import com.buddhi.blog.models.Post;
import com.buddhi.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Long createPost(PostDto postDto){
        Post post = new Post();
        copyProperties(postDto, post);
        post.setCreationTime(new Date());
        Post postDb = postRepository.save(post);
        return postDb.getId();
    }
}
