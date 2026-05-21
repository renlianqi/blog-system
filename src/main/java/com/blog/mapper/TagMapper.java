package com.blog.mapper;

import com.blog.entity.Tag;
import java.util.List;

public interface TagMapper {
    // 查询所有标签
    List<Tag> selectAllTags();
}