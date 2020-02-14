package com.kaini.teachingmanager.service;

import com.kaini.teachingmanager.pojo.Lesson;
import com.kaini.teachingmanager.request.AddLessonRequest;

import java.util.List;

public interface LessonService {
    List<Lesson> findAllLesson(Integer pageSize, Integer pageNumber);

    Integer insertLesson(AddLessonRequest lessonRequest);

    Integer deleteAllLesson(List<Long> ids);

    List<Lesson> selectLikeLesson(String type);
}
