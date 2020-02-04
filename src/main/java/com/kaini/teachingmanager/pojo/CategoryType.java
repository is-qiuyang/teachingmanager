package com.kaini.teachingmanager.pojo;

import javax.persistence.*;

@Table(name = "category_type")
public class CategoryType {
    /**
     * 章节ID
     */
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    /**
     * 课程ID
     */
    @Id
    @Column(name = "lesson_id")
    private Long lessonId;

    /**
     * 章节名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 上传资源
     */
    @Column(name = "category_resource")
    private String categoryResource;

    /**
     * 获取章节ID
     *
     * @return category_id - 章节ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置章节ID
     *
     * @param categoryId 章节ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

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
     * 获取章节名称
     *
     * @return category_name - 章节名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置章节名称
     *
     * @param categoryName 章节名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取上传资源
     *
     * @return category_resource - 上传资源
     */
    public String getCategoryResource() {
        return categoryResource;
    }

    /**
     * 设置上传资源
     *
     * @param categoryResource 上传资源
     */
    public void setCategoryResource(String categoryResource) {
        this.categoryResource = categoryResource == null ? null : categoryResource.trim();
    }
}