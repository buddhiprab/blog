package com.buddhi.blog.controllers;

import com.buddhi.blog.dto.PostDto;
import com.buddhi.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.beans.BeanUtils.copyProperties;

@RestController
public class BlogController {
    @Autowired
    PostService postService;

    @PostMapping("/createPost")
    public ResponseEntity<Long> createPost(@RequestBody PostDto req){
        Long id = postService.createPost(req);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
