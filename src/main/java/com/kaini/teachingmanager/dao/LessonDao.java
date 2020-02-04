package com.kaini.teachingmanager.dao;

import com.kaini.teachingmanager.mapper.LessonMapper;
import com.kaini.teachingmanager.pojo.CategoryType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LessonDao {
    @Autowired
    private LessonMapper lessonMapper;
    /**
     * 通过分类名获取ID
     *
     * @param name 分类名
     *
     * @return {@link Long}
     */
    public Long getIdByName(String name){

        return null;
    }

    /**
     * 添加一个分类
     *
     * @param name 分类名
     *
     * @return 是否添加成功
     */
    public boolean insertCategory(String name,long lessonId){

        return false;
    }

    /**
     * 通过编号删除一个分类
     *
     * @param id 编号
     *
     * @return 是否删除成功
     */
    public boolean removeCategoryById(int id){

        return false;
    }

    /**
     * 通过名称删除一个分类
     *
     * @param name 分类名称
     *
     * @return 是否删除成功
     */
    public int removeCategoryByName(String name){

        return 0;
    }

    /**
     * 更新一个分类名
     *
     * @param name 分类名
     * @param id 分类ID
     *
     * @return 是否更新成功
     */
    public boolean updateNameById(@Param("id") long id, @Param("name") String name){

        return false;
    }

    /**
     * 通过分类名更新分类名
     *
     * @param newName 新的分类名
     * @param oldName 旧的分类名
     */
    public void updateNameByName(String newName, String oldName){

    }

    /**
     * 获取所有分类
     *
     * @return {@link List}
     */
    public List<CategoryType> listCategory(){
        return null;
    }

    /**
     * 通过编号获取一个分类
     *
     * @param id 编号
     *
     * @return {@link CategoryType}
     */
    public CategoryType getCategoryById(long id){

        return null;
    }

    /**
     * 通过名称获取一个分类
     *
     * @param name 名称
     *
     * @return {@link CategoryType}
     */
    public CategoryType getCategoryByName(String name){
        return null;
    }


}
