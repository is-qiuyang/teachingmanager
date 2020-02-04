package com.kaini.teachingmanager.pojo;

import javax.persistence.*;

@Table(name = "file")
public class File {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 客户端访问路径
     */
    @Column(name = "visit_url")
    private String visitUrl;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取文件名
     *
     * @return name - 文件名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文件名
     *
     * @param name 文件名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取客户端访问路径
     *
     * @return visit_url - 客户端访问路径
     */
    public String getVisitUrl() {
        return visitUrl;
    }

    /**
     * 设置客户端访问路径
     *
     * @param visitUrl 客户端访问路径
     */
    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl == null ? null : visitUrl.trim();
    }
}