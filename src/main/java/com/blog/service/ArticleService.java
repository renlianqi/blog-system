package com.blog.service;

import com.blog.entity.Article;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface ArticleService {
    // 发布文章
    void addArticle(Article article, List<Long> tagIds);

    // 组合分页查询
    PageInfo<Article> findArticleList(String title, Long tagId, String startTime,
                                      String endTime, Integer pageNum, Integer pageSize);

    // 查询详情
    Article findArticleById(Long id);
}