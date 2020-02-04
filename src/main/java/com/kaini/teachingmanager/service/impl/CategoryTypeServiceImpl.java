package com.kaini.teachingmanager.service.impl;

import com.kaini.teachingmanager.dao.CategoryTypeDao;
import com.kaini.teachingmanager.pojo.CategoryType;
import com.kaini.teachingmanager.service.CategoryTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class CategoryTypeServiceImpl implements CategoryTypeService {

    @Autowired
    private CategoryTypeDao categoryTypeDao;

    @Override
    public boolean insert(String name,long lessonId) {
        return categoryTypeDao.insertCategory(name,lessonId);
    }

    @Override
    public boolean remove(int id) {
        return categoryTypeDao.removeCategoryById(id);
    }

    @Override
    public boolean update(long id, String name) {
        return categoryTypeDao.updateNameById(id, name);
    }

    @Override
    public CategoryType getById(long id) {
        return categoryTypeDao.getCategoryById(id);
    }

    @Override
    public List<CategoryType> list() {
        return categoryTypeDao.listCategory();
    }

    @Override
    public long getIdByName(String name) {
        try {
            return categoryTypeDao.getIdByName(name);
        } catch (Exception e) {
            return Long.MAX_VALUE;
        }
    }

    @Override
    public long getLessonIdByName(String name) {
        return categoryTypeDao.getLessonIdByName(name);
    }


}
