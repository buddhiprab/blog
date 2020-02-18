package com.buddhi.blog.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String title;
    private String content;
    private Long postId;
}
