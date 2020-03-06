package com.kaini.teachingmanager.service;

import com.kaini.teachingmanager.pojo.Lesson;
import com.kaini.teachingmanager.request.AddLessonRequest;
import com.kaini.teachingmanager.request.GetAllLessonRequest;

import java.util.List;

public interface LessonService {
    List<Lesson> findAllLesson(GetAllLessonRequest getAllLessonRequest);

    Integer insertLesson(AddLessonRequest lessonRequest);

    Integer deleteAllLesson(List<Long> ids);

    List<Lesson> selectLikeLesson(String type);
}
