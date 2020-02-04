package com.kaini.teachingmanager.pojo;

import javax.persistence.*;

@Table(name = "point")
public class Point {
    /**
     * 知识点ID
     */
    @Id
    @Column(name = "point_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;

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
     * 重要程度：1、拔高2、非常重要3、重要4、不太重要5、没时间看算了6、根本不会考
     */
    @Column(name = "point_importance")
    private Long pointImportance;

    /**
     * 获取知识点ID
     *
     * @return point_id - 知识点ID
     */
    public Long getPointId() {
        return pointId;
    }

    /**
     * 设置知识点ID
     *
     * @param pointId 知识点ID
     */
    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    /**
     * @return category_id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取知识点名称
     *
     * @return point_name - 知识点名称
     */
    public String getPointName() {
        return pointName;
    }

    /**
     * 设置知识点名称
     *
     * @param pointName 知识点名称
     */
    public void setPointName(String pointName) {
        this.pointName = pointName == null ? null : pointName.trim();
    }

    /**
     * 获取知识点描述
     *
     * @return point_desc - 知识点描述
     */
    public String getPointDesc() {
        return pointDesc;
    }

    /**
     * 设置知识点描述
     *
     * @param pointDesc 知识点描述
     */
    public void setPointDesc(String pointDesc) {
        this.pointDesc = pointDesc == null ? null : pointDesc.trim();
    }

    /**
     * 获取重要程度：1、拔高2、非常重要3、重要4、不太重要5、没时间看算了6、根本不会考
     *
     * @return point_importance - 重要程度：1、拔高2、非常重要3、重要4、不太重要5、没时间看算了6、根本不会考
     */
    public Long getPointImportance() {
        return pointImportance;
    }

    /**
     * 设置重要程度：1、拔高2、非常重要3、重要4、不太重要5、没时间看算了6、根本不会考
     *
     * @param pointImportance 重要程度：1、拔高2、非常重要3、重要4、不太重要5、没时间看算了6、根本不会考
     */
    public void setPointImportance(Long pointImportance) {
        this.pointImportance = pointImportance;
    }
}