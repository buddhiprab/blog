package com.buddhi.blog.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostDetailDto {
    private String title;
    private String content;
    private List<CommentDetailDto> comments;
}
