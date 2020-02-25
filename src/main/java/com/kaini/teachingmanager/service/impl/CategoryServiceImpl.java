package com.kaini.teachingmanager.service.impl;

import com.kaini.teachingmanager.dao.CategoryDao;
import com.kaini.teachingmanager.pojo.Category;
import com.kaini.teachingmanager.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public boolean insert(String name,long lessonId) {
        return categoryDao.insertCategory(name,lessonId);
    }

    @Override
    public Integer remove(List<Long> ids) {
        return categoryDao.removeCategoryByIds(ids);
    }

    @Override
    public boolean update(long id, String name) {
        return categoryDao.updateNameById(id, name);
    }

    @Override
    public List<Category> selectCateByLessonId(Long lessonId) {
        return categoryDao.selectCateByLessonId(lessonId);
    }

    @Override
    public Integer removeCategoryByLessonId(Long lessonId) {
        return categoryDao.removeCategoryByLessonId(lessonId);
    }


}
