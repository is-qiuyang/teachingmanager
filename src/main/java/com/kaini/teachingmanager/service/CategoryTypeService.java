package com.kaini.teachingmanager.service;

import com.kaini.teachingmanager.pojo.CategoryType;

import java.util.List;

public interface CategoryTypeService {
    /**
     * 添加一个分类
     *
     * @param name 分类名称
     *
     * @return 是否添加成功
     */
    boolean insert(String name,long lessonId);

    /**
     * 删除一个分类
     *
     * @param id 分类编号
     *
     * @return 是否删除成功
     */
    boolean remove(int id);

    /**
     * 更新分类
     *
     * @param id 分类编号
     * @param name 分类名称
     *
     * @return 是否更新成功
     */
    boolean update(long id, String name);

    /**
     * 获取一个分类
     *
     * @param id 分类编号
     * @return {@link CategoryType}
     */
    CategoryType getById(long id);

    /**
     * 获取所有的分类
     *
     * @return {@link List}
     */
    List<CategoryType> list();

    /**
     * 通过分类名获取ID
     *
     * @param name 分类名
     *
     * @return {@link Integer}
     */
    long getIdByName(String name);

    /**
     * 通过名称获取lessonId
     *
     * @param name 名称
     *
     * @return {@link Long}
     */
    public long getLessonIdByName(String name);
}
