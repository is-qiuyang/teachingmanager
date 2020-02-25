package com.kaini.teachingmanager.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class FindFileByNameResponse {
    /**
     * 文件名
     */
    private String name;

    /**
     * 客户端访问路径
     */
    @Column(name = "visit_url")
    private String visitUrl;
}
