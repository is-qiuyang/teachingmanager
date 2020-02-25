package com.kaini.teachingmanager.service;

import com.kaini.teachingmanager.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    /**
     * 添加一个分类
     *
     * @param name 分类名称
     *
     * @return 是否添加成功
     */
    boolean insert(String name,long lessonId);

    /**
     * 批量删除章节
     *
     * @param ids 章节编号
     *
     * @return 是否删除成功
     */
    Integer remove(List<Long> ids);

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
     * 方法描述
     * @ 通过课程ID查询章节
     * @return
     * @date 2020/2/19
     */
    List<Category> selectCateByLessonId(Long lessonId);

    /**
     * 方法描述
     * @ 通过lessonId删除
     * @return
     * @date 2020/2/25
     */
    Integer removeCategoryByLessonId(Long lessonId);
}
