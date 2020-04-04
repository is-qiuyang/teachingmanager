package com.kaini.teachingmanager.service.impl;

import com.kaini.teachingmanager.dao.PointDao;
import com.kaini.teachingmanager.pojo.Point;
import com.kaini.teachingmanager.request.InsertPointRequest;
import com.kaini.teachingmanager.request.UpdateByIdRequest;
import com.kaini.teachingmanager.service.PointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PointServiceImpl implements PointService {
    @Autowired
    private PointDao pointDao;

    @Override
    public Integer insertPoint(InsertPointRequest pointRequest) {
        Point point = new Point();
        Long pointImportance = pointRequest.getPointImportance();
        if(pointImportance>5 || pointImportance<0 || pointImportance == null ){
            point.setPointImportance((long)0);
        }else {
            point.setPointImportance(pointRequest.getPointImportance());
        }
        point.setCategoryId(pointRequest.getCategoryId());
        point.setPointDesc(pointRequest.getPointDesc());
        point.setPointName(pointRequest.getPointName());
        return pointDao.insertPoint(point);
    }

    @Override
    public Integer removePointByIds(List<Long> ids) {
        return pointDao.removePointByIds(ids);
    }

    @Override
    public boolean updateNameById(UpdateByIdRequest pointRequest) {

        Point point = new Point();
        log.info("pointRequest:",pointRequest.toString());

        Long pointImportance = pointRequest.getPointImportance();
        if(pointImportance != null){
        if(pointImportance>5 || pointImportance<0){
            point.setPointImportance((long)0);
        }}
        BeanUtils.copyProperties(pointRequest,point);
        log.info("Dao层",pointDao.updateNameById(point));
        return pointDao.updateNameById(point);
    }

    @Override
    public List<Point> selectPointByCategoryId(Long categoryId) {

        return pointDao.selectPointByCategoryId(categoryId);

    }

    @Override
    public Integer deletePointByCategoryId(Long categoryId) {
        return pointDao.deletePointByCategoryId(categoryId);
    }
}
