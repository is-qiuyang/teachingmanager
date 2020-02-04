package com.kaini.teachingmanager.dao;

import com.kaini.teachingmanager.mapper.CategoryTypeMapper;
import com.kaini.teachingmanager.pojo.CategoryType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class CategoryTypeDao {
    @Autowired
    private CategoryTypeMapper categoryTypeMapper;
    /**
     * 通过分类名获取ID
     *
     * @param name 分类名
     *
     * @return {@link Integer}
     */
    public Long getIdByName(String name){
        Example example = new Example(CategoryType.class);
        example.createCriteria().andEqualTo("categoryName",name);
        return categoryTypeMapper.selectByPrimaryKey(example).getCategoryId();
    }

    /**
     * 添加一个分类
     *
     * @param name 分类名
     *
     * @return 是否添加成功
     */
    public boolean insertCategory(String name,long lessonId){
        CategoryType categoryType = new CategoryType();
        categoryType.setCategoryName(name);
        categoryType.setLessonId(lessonId);
        if(categoryTypeMapper.insertSelective(categoryType)==1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 通过编号删除一个分类
     *
     * @param id 编号
     *
     * @return 是否删除成功
     */
    public boolean removeCategoryById(int id){
       if(categoryTypeMapper.deleteByPrimaryKey(id)==1){
           return true;
       }else {
           return false;
       }

    }

    /**
     * 通过名称删除一个分类
     *
     * @param name 分类名称
     *
     * @return 是否删除成功
     */
    public int removeCategoryByName(String name){
        Example example = new Example(CategoryType.class);
        example.createCriteria().andEqualTo("categoryName",name);
        return categoryTypeMapper.deleteByExample(example);
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
        Example example = new Example(CategoryType.class);
        example.createCriteria().andEqualTo("categoryId",id);
        CategoryType categoryType = new CategoryType();
        categoryType.setCategoryName(name);
        if(categoryTypeMapper.updateByExample(categoryType,example)==1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 通过分类名更新分类名
     *
     * @param newName 新的分类名
     * @param oldName 旧的分类名
     */
    public void updateNameByName(String newName, String oldName){
        CategoryType categoryType = new CategoryType();
        categoryType.setCategoryName(newName);
        Example example = new Example(CategoryType.class);
        example.createCriteria().andEqualTo("categoryName",oldName);
        categoryTypeMapper.updateByExample(categoryType,example);
    }

    /**
     * 获取所有分类
     *
     * @return {@link List}
     */
    public List<CategoryType> listCategory(){return categoryTypeMapper.selectAll();}

    /**
     * 通过编号获取一个分类
     *
     * @param id 编号
     *
     * @return {@link CategoryType}
     */
    public CategoryType getCategoryById(long id){
        Example example = new Example(CategoryType.class);
        example.createCriteria().andEqualTo("categoryId",id);
        return categoryTypeMapper.selectOneByExample(example);
    }

    /**
     * 通过名称获取一个分类
     *
     * @param name 名称
     *
     * @return {@link CategoryType}
     */
    public CategoryType getCategoryByName(String name){
        Example example = new Example(CategoryType.class);
        example.createCriteria().andEqualTo("categoryName",name);
        return categoryTypeMapper.selectByPrimaryKey(example);

    }

    /**
     * 通过名称获取lessonId
     *
     * @param name 名称
     *
     * @return {@link Long}
     */
    public long getLessonIdByName(String name){
        Example example = new Example(CategoryType.class);
        example.createCriteria().andEqualTo("categoryName",name);
        CategoryType categoryType = categoryTypeMapper.selectByPrimaryKey(example);
        return categoryType.getLessonId();
    }
}
