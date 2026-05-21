package com.blog.entity;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Article {
    private Long id;
    private String title;       // 标题
    private String content;     // 内容
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // 关联标签（一对多）
    private List<Tag> tags;
}