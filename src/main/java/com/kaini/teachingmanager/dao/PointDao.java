package com.kaini.teachingmanager.dao;

import com.kaini.teachingmanager.mapper.PointMapper;
import com.kaini.teachingmanager.pojo.Point;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class PointDao {
    @Autowired
    private PointMapper pointMapper;

    /**
     * 添加一个重点
     *
     * @return 是否添加成功
     */
    public Integer insertPoint(Point point){
        return pointMapper.insert(point);
    }

    /**
     * 批量删除重点
     *
     * @param ids ID
     *
     * @return 删除了多少个
     */
    public Integer removePointByIds(List<Long> ids){
        Example example = new Example(Point.class);
        example.createCriteria().andIn("id",ids);
        return pointMapper.deleteByExample(example);
    }


    /**
     * 更新一个重点
     *
     * @param
     *
     * @return 是否更新成功
     */
    public boolean updateNameById(Point point){
        if(pointMapper.updateByPrimaryKey(point)==1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 方法描述
     * @ 查询所有重点
     * @return
     * @date 2020/2/21
     */
    public List<Point> selectPointByCategoryId(Long categoryId){
        Example example = new Example(Point.class);
        example.createCriteria().andEqualTo("categoryId",categoryId);
        return pointMapper.selectByExample(example);
    }

    /**
     * 方法描述
     * @ 根据ID查询
     * @return
     * @date 2020/2/24
     */
    public Point selectPointById(@Param("pointId") Long pointId){
        return pointMapper.selectByPrimaryKey(pointId);
    }

    //通过分类编号删除重点
    public int deletePointByCategoryId(int categoryId){
        Example example = new Example(Point.class);
        example.createCriteria().andEqualTo("categoryId",categoryId);
        return pointMapper.deleteByExample(example);
    }
}
