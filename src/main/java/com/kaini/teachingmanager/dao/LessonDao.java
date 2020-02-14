package com.kaini.teachingmanager.dao;

import com.kaini.teachingmanager.mapper.LessonMapper;
import com.kaini.teachingmanager.pojo.Lesson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class LessonDao {
    @Autowired
    private LessonMapper lessonMapper;
    
    /**
     * 方法描述
     * @ 获取所有课程
     * @return 
     * @date 2020/2/14
     */
    public List<Lesson> selectAllLesson(){

        return lessonMapper.selectAll();
    }

    /**
     * 方法描述
     * @ 添加一个分类
     * @return 
     * @date 2020/2/14
     */
    public Integer insertLesson(Lesson lesson) {
        return lessonMapper.insert(lesson);
    }

    /**
     * 方法描述
     * @ 批量删除
     * @return
     * @date 2020/2/12
     */
    public Integer deleteAllLesson(List<Long> ids) {
        Example example = new Example(Lesson.class);
        example.createCriteria().andIn("lesson_id", ids);
        return lessonMapper.deleteByExample(example);
    }

    /**
     * 方法描述
     * @ 模糊查询
     * @return
     * @date 2020/2/15
     */
    public List<Lesson> selectLikeLesson(String type){
        Example example = new Example(Lesson.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(type)){
            type = "%" + type +"%";
        }
        if (StringUtils.isNotBlank(type)){
            criteria.andLike("type",type);
        }
        return lessonMapper.selectByExample(criteria);
    }
}
