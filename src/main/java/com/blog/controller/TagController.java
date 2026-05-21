package com.blog.controller;

import com.blog.service.TagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Resource
    private TagService tagService;
}