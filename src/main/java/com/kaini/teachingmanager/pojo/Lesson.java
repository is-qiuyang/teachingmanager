package com.kaini.teachingmanager.pojo;

import java.util.Date;
import javax.persistence.*;

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
     * 分类ID
     */
    @Id
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 标题
     */
    @Column(name = "a_title")
    private String aTitle;

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
     * 主题图片的URL
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 年级
     */
    private String calss;

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
     * 获取分类ID
     *
     * @return type_id - 分类ID
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置分类ID
     *
     * @param typeId 分类ID
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取标题
     *
     * @return a_title - 标题
     */
    public String getaTitle() {
        return aTitle;
    }

    /**
     * 设置标题
     *
     * @param aTitle 标题
     */
    public void setaTitle(String aTitle) {
        this.aTitle = aTitle == null ? null : aTitle.trim();
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
     * 获取主题图片的URL
     *
     * @return image_url - 主题图片的URL
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置主题图片的URL
     *
     * @param imageUrl 主题图片的URL
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * 获取年级
     *
     * @return calss - 年级
     */
    public String getCalss() {
        return calss;
    }

    /**
     * 设置年级
     *
     * @param calss 年级
     */
    public void setCalss(String calss) {
        this.calss = calss == null ? null : calss.trim();
    }
}