package com.buddhi.blog.services;

import com.buddhi.blog.dto.CommentDto;
import com.buddhi.blog.dto.PostDto;
import com.buddhi.blog.models.Comment;
import com.buddhi.blog.models.Post;
import com.buddhi.blog.repositories.CommentRepository;
import com.buddhi.blog.repositories.PostRepository;
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
    @Autowired
    CommentRepository commentRepository;

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

    public List<PostDto> search(String text) {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> posts = postRepository.search(text);
        for(Post post:posts){
            PostDto postDto = new PostDto();
            copyProperties(post,postDto);
            postDtos.add(postDto);
        }
        return postDtos;
    }

    public List<PostDto> searchByTitle(String text) {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> posts = postRepository.findByTitleContaining(text);
        for(Post post:posts){
            PostDto postDto = new PostDto();
            copyProperties(post,postDto);
            postDtos.add(postDto);
        }
        return postDtos;
    }

    public Long createComment(CommentDto commentDto) {
        Comment comment = new Comment();
        copyProperties(commentDto, comment);
        comment.setCreationTime(new Date());
        Comment commentDb = commentRepository.save(comment);
        return commentDb.getId();
    }

    public PostDto getPost(Long id) {
        PostDto postDto = new PostDto();
        Post post = postRepository.findById(id).orElse(null);
        copyProperties(post, postDto);
        List <Comment> comments = commentRepository.findByPostId(id);
        List <CommentDto> commentDtos = new ArrayList<>();
        for(Comment comment:comments){
            CommentDto commentDto = new CommentDto();
            copyProperties(comment, commentDto);
            commentDtos.add(commentDto);
        }
        postDto.setComments(commentDtos);
        return postDto;
    }

    public Long deleteComment(Long postId, CommentDto commentDto) {
        commentRepository.deleteComment(postId, commentDto.getId());
        return commentDto.getId();
    }
}
