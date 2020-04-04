package com.kaini.teachingmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaini.teachingmanager.dao.LessonDao;
import com.kaini.teachingmanager.pojo.Lesson;
import com.kaini.teachingmanager.request.AddLessonRequest;
import com.kaini.teachingmanager.request.GetAllLessonRequest;
import com.kaini.teachingmanager.service.LessonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonDao lessonDao;

    @Override
    public List<Lesson> findAllLesson(GetAllLessonRequest getAllLessonRequest) {
        Integer pageSize = 6 ;
        //开始分页，必须写在上面
        Integer pageNumber = getAllLessonRequest.getPageNumber();
        PageHelper.startPage(pageNumber,pageSize);
        List<Lesson> all = lessonDao.selectAllLesson();
        PageInfo<Lesson> pageInfo=new PageInfo<>(all);
        log.info("all-{}",all);
        log.info("pageInfo.getList()-{}",pageInfo.getList());
        log.info("pagesize-{},pageNumber-{}",pageSize,pageNumber);
        return pageInfo.getList();
    }

    @Override
    public Integer insertLesson(AddLessonRequest lessonRequest) {
        Lesson lesson = new Lesson();
        BeanUtils.copyProperties(lessonRequest,lesson);
        return lessonDao.insertLesson(lesson);
    }

    @Override
    public Integer deleteAllLesson(List<Long> ids) {
        return lessonDao.deleteAllLesson(ids);
    }

    @Override
    public List<Lesson> selectLikeLesson(String type) {
        return lessonDao.selectLikeLesson(type);
    }
}
