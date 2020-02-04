package com.kaini.teachingmanager.pojo;

import javax.persistence.*;

@Table(name = "lesson_type")
public class LessonType {
    /**
     * 课程分类ID
     */
    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    /**
     * 分类名
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 获取课程分类ID
     *
     * @return lesson_id - 课程分类ID
     */
    public Long getLessonId() {
        return lessonId;
    }

    /**
     * 设置课程分类ID
     *
     * @param lessonId 课程分类ID
     */
    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    /**
     * 获取分类名
     *
     * @return type_name - 分类名
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置分类名
     *
     * @param typeName 分类名
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}