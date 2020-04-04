package com.kaini.teachingmanager.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "lesson")
public class Lesson {
    /**
     * 课程ID
     */
    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    /**
     * 课程名
     */
    private String type;

    /**
     * 课程简介
     */
    @Column(name = "a_text")
    private String aText;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 年级
     */
    @Column(name = "l_class")
    private String lClass;

    /**
     * 获取课程ID
     *
     * @return lesson_id - 课程ID
     */
    public Long getLessonId() {
        return lessonId;
    }

    /**
     * 设置课程ID
     *
     * @param lessonId 课程ID
     */
    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    /**
     * 获取课程名
     *
     * @return type - 课程名
     */
    public String getType() {
        return type;
    }

    /**
     * 设置课程名
     *
     * @param type 课程名
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取课程简介
     *
     * @return a_text - 课程简介
     */
    public String getaText() {
        return aText;
    }

    /**
     * 设置课程简介
     *
     * @param aText 课程简介
     */
    public void setaText(String aText) {
        this.aText = aText == null ? null : aText.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取年级
     *
     * @return l_class - 年级
     */
    public String getlClass() {
        return lClass;
    }

    /**
     * 设置年级
     *
     * @param lClass 年级
     */
    public void setlClass(String lClass) {
        this.lClass = lClass == null ? null : lClass.trim();
    }
}