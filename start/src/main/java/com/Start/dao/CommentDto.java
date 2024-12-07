package com.Start.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto {

    private Long id;
    private String article;
    private String content;
    private String author;
    private String createdDate;
}
