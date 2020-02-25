package com.kaini.teachingmanager.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class InsertPointRequest {
    @Id
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 知识点名称
     */
    @Column(name = "point_name")
    private String pointName;

    /**
     * 知识点描述
     */
    @Column(name = "point_desc")
    private String pointDesc;

    /**
     * 重要程度：1、拔高2、非常重要 3、重要4、不太重要5、没时间看算了6、根本不会考
     */
    @Column(name = "point_importance")
    private Long pointImportance;


}
