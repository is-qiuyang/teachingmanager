package com.kaini.teachingmanager.dao;

import com.kaini.teachingmanager.mapper.CategoryMapper;
import com.kaini.teachingmanager.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class CategoryDao {

    @Autowired
    private CategoryMapper categoryMapper;
    
    /**
     * 添加一个章节
     *
     * @param name 章节名 lessonId课程ID
     *
     * @return 是否添加成功
     */
    public boolean insertCategory(String name,long lessonId){
        Category categoryType = new Category();
        categoryType.setCategoryName(name);
        categoryType.setLessonId(lessonId);
        if(categoryMapper.insertSelective(categoryType)==1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 批量删除章节
     *
     * @param ids 编号
     *
     * @return 删除了多少个
     */
    public Integer removeCategoryByIds(List<Long> ids){
        Example example = new Example(Category.class);
        example.createCriteria().andIn("id",ids);
        return categoryMapper.deleteByExample(example);
    }


    /**
     * 更新一个章节名
     *
     * @param name 章节名
     * @param id 章节ID
     *
     * @return 是否更新成功
     */
    public boolean updateNameById(@Param("id") long id, @Param("name") String name){
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("categoryId",id);
        Category category = new Category();
        category.setCategoryName(name);
        if(categoryMapper.updateByExample(category,example)==1){
            return true;
        }else {
            return false;
        }
    }
    
    /**
     * 方法描述
     * @ 通过课程ID查询章节
     * @return 
     * @date 2020/2/19
     */
    public List<Category> selectCateByLessonId(Long lessonId){
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("lessonId",lessonId);
        return categoryMapper.selectByExample(example);
    }

    /**
     * 方法描述
     * @ 通过lessonId删除
     * @return
     * @date 2020/2/25
     */
    public Integer removeCategoryByLessonId(Long lessonId){
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("lessonId",lessonId);
        return categoryMapper.deleteByExample(example);
    }
}
