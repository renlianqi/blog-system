package com.blog.service.impl;

import com.blog.entity.Article;
import com.blog.mapper.ArticleMapper;
import com.blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    // 事务：新增文章+关联标签
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addArticle(Article article, List<Long> tagIds) {
        // 1. 新增文章
        articleMapper.insertArticle(article);
        // 2. 批量新增标签关联
        for (Long tagId : tagIds) {
            articleMapper.insertArticleTag(article.getId(), tagId);
        }
    }

    // 分页条件查询
    @Override
    public PageInfo<Article> findArticleList(String title, Long tagId, String startTime,
                                             String endTime, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = articleMapper.selectArticleList(title, tagId, startTime, endTime);
        return new PageInfo<>(list);
    }

    // 查询详情
    @Override
    public Article findArticleById(Long id) {
        return articleMapper.selectArticleById(id);
    }
}