package com.blog.controller;

import com.blog.entity.Article;
import com.blog.service.ArticleService;
import com.blog.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;
    @Resource
    private TagService tagService;

    // 跳转发布文章页面
    @GetMapping("/add")
    public String toAdd(Model model) {
        model.addAttribute("tags", tagService.findAllTags());
        return "article/add";
    }

    // 发布文章
    @PostMapping("/add")
    public String add(Article article, @RequestParam List<Long> tagIds) {
        articleService.addArticle(article, tagIds);
        return "redirect:/article/list";
    }

    // 文章列表+组合分页查询
    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       @RequestParam(required = false) String title,
                       @RequestParam(required = false) Long tagId,
                       @RequestParam(required = false) String startTime,
                       @RequestParam(required = false) String endTime,
                       Model model) {
        PageInfo<Article> page = articleService.findArticleList(title, tagId, startTime, endTime, pageNum, pageSize);
        model.addAttribute("page", page);
        model.addAttribute("tags", tagService.findAllTags());
        // 回显查询条件
        model.addAttribute("title", title);
        model.addAttribute("tagId", tagId);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        return "article/list";
    }

    // 文章详情
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Article article = articleService.findArticleById(id);
        model.addAttribute("article", article);
        return "article/detail";
    }
}