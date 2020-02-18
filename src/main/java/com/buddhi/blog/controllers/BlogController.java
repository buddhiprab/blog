package com.buddhi.blog.controllers;

import com.buddhi.blog.dto.PostDto;
import com.buddhi.blog.models.Post;
import com.buddhi.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("posts")
    public ResponseEntity<List<PostDto>> getPosts(){
        List<PostDto> postDtos = postService.getPosts();
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

    @GetMapping("search/{text}")
    public ResponseEntity<List<PostDto>> search(@PathVariable("text") String text){
        List<PostDto> postDtos = postService.search(text);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<List<PostDto>> searchByTitle(@RequestParam("title") String text){
        List<PostDto> postDtos = postService.searchByTitle(text);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }
}
