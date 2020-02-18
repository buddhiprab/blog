package com.buddhi.blog.controllers;

import com.buddhi.blog.dto.CommentDto;
import com.buddhi.blog.dto.PostDto;
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
    public ResponseEntity<Long> createPost(@RequestBody PostDto postDto){
        Long id = postService.createPost(postDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getPosts(){
        List<PostDto> postDtos = postService.getPosts();
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

    @GetMapping("/search/{text}")
    public ResponseEntity<List<PostDto>> search(@PathVariable("text") String text){
        List<PostDto> postDtos = postService.search(text);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PostDto>> searchByTitle(@RequestParam("title") String text){
        List<PostDto> postDtos = postService.searchByTitle(text);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

    @PostMapping("/addComment")
    public ResponseEntity<Long> addComment(@RequestBody CommentDto commentDto){
        Long id = postService.createComment(commentDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable("id") Long id){
        PostDto postDto = postService.getPost(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @PostMapping("/deleteComment/{postId}")
    public ResponseEntity<Long> deleteComment(@PathVariable("postId") Long postId, @RequestBody CommentDto commentDto){
        Long id = postService.deleteComment(postId, commentDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
