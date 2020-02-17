package com.buddhi.blog.services;

import com.buddhi.blog.dto.PostDto;
import com.buddhi.blog.models.Post;
import com.buddhi.blog.repositories.PostRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<PostDto> getPosts() {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> posts = postRepository.findAll();
        for(Post post:posts){
            PostDto postDto = new PostDto();
            copyProperties(post,postDto);
            postDtos.add(postDto);
        }
        return postDtos;
    }
}
