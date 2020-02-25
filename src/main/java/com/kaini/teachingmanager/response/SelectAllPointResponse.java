package com.kaini.teachingmanager.response;

import javax.persistence.Column;

public class SelectAllPointResponse {

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


    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointDesc() {
        return pointDesc;
    }

    public void setPointDesc(String pointDesc) {
        this.pointDesc = pointDesc;
    }

    public Long getPointImportance() {
        return pointImportance;
    }

    public void setPointImportance(Long pointImportance) {
        this.pointImportance = pointImportance;
    }
}
