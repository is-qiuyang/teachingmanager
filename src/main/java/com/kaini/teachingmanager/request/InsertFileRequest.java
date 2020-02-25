package com.kaini.teachingmanager.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class InsertFileRequest {

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
     * 章节ID
     */
    @Column(name = "category_id")
    private byte[] categoryId;
}
