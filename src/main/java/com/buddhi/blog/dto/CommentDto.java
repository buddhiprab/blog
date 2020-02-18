package com.buddhi.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CommentDto {
    private String title;
    private String content;
    private Long postId;
}
