package com.kaini.teachingmanager.request;

import javax.persistence.Column;

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
    private String calss;

    public String getType() {
        return type;
    }


    public String getaText() {
        return aText;
    }


    public String getCalss() {
        return calss;
    }
}
