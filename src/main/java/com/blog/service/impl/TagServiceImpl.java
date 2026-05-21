package com.blog.service.impl;

import com.blog.entity.Tag;
import com.blog.mapper.TagMapper;
import com.blog.service.TagService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> findAllTags() {
        return tagMapper.selectAllTags();
    }
}