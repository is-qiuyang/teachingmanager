package com.kaini.teachingmanager.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AddLessonRequest {

    /**
     * 分类
     */
    private String type;


    /**
     * 课程简介
     */
    @Column(name = "a_text")
    private String aText;



    /**
     * 年级
     */
    private String lClass;


}
