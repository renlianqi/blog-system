package com.blog.mapper;

import com.blog.entity.Article;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ArticleMapper {
    // 新增文章
    int insertArticle(Article article);

    // 新增文章-标签关联
    void insertArticleTag(@Param("articleId") Long articleId, @Param("tagId") Long tagId);

    // 组合条件分页查询文章
    List<Article> selectArticleList(@Param("title") String title,
                                    @Param("tagId") Long tagId,
                                    @Param("startTime") String startTime,
                                    @Param("endTime") String endTime);

    // 根据ID查询文章详情（含所有标签）
    Article selectArticleById(Long id);

    // 删除文章关联标签
    void deleteArticleTag(Long articleId);
}