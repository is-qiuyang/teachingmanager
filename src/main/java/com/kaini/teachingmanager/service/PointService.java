package com.kaini.teachingmanager.service;

import com.kaini.teachingmanager.pojo.Point;
import com.kaini.teachingmanager.request.InsertPointRequest;
import com.kaini.teachingmanager.request.UpdateByIdRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PointService {
    /**
     * 添加一个重点
     *
     * @return 是否添加成功
     */
    Integer insertPoint(InsertPointRequest pointRequest);

    /**
     * 批量删除重点
     *
     * @param ids ID
     *
     * @return 删除了多少个
     */
    Integer removePointByIds(@Param("id") List<Long> ids);

    /**
     * 更新一个重点
     *
     * @param
     *
     * @return 是否更新成功
     */
    boolean updateNameById(UpdateByIdRequest pointRequest);

    /**
     * 方法描述
     * @ 查询所有重点
     * @return
     * @date 2020/2/21
     */
    List<Point> selectPointByCategoryId(Long categoryId);

    //通过分类编号删除重点
    Integer deletePointByCategoryId(Long categoryId);
}
