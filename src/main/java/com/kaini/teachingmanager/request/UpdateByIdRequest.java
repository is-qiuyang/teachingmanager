package com.kaini.teachingmanager.request;

import lombok.Data;

import javax.persistence.Column;
@Data
public class UpdateByIdRequest {
    private Long pointId;

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
     * 重要程度：5、拔高4、非常重要 3、重要2、不太重要1、没时间看算了0、根本不会考
     */
    @Column(name = "point_importance")
    private Long pointImportance;

}
