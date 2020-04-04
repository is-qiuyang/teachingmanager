package com.kaini.teachingmanager.controller;

import com.kaini.teachingmanager.common.SzpJsonResult;
import com.kaini.teachingmanager.request.CategoryIdRequest;
import com.kaini.teachingmanager.request.IdsListRequest;
import com.kaini.teachingmanager.request.InsertPointRequest;
import com.kaini.teachingmanager.request.UpdateByIdRequest;
import com.kaini.teachingmanager.response.SelectAllPointResponse;
import com.kaini.teachingmanager.service.PointService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PointController {
    @Autowired
    private PointService pointService;

    /**
     * 添加一个重点
     *
     * @return 是否添加成功
     */
    @ApiOperation(value = "新增一个重点")

    @RequestMapping(value = "/point/insert", method = RequestMethod.POST)
    public SzpJsonResult<String> insertPoint(@RequestBody InsertPointRequest pointRequest){
        Integer integer = pointService.insertPoint(pointRequest);
        if(integer==1){
            return SzpJsonResult.ok("成功添加重点");
        }
        return SzpJsonResult.ok("添加失败");
    }

    /**
     * 批量删除重点
     *
     * @param
     *
     * @return 删除了多少个
     */
    @ApiOperation(value = "批量删除重点")
    @RequestMapping(value = "/point/deleteSome", method = RequestMethod.POST)
    public SzpJsonResult<String> removePointByIds(@RequestBody IdsListRequest request){

        Integer integer = pointService.removePointByIds(request.getIds());

        if (integer>0){
            return SzpJsonResult.ok("成功删除"+integer+"个重点");
        }
        return SzpJsonResult.ok("删除失败");
    }

    /**
     * 更新一个重点
     *
     * @param
     *
     * @return 是否更新成功
     */
    @ApiOperation(value = "更新一个重点")
    @RequestMapping(value = "/point/updateById", method = RequestMethod.PUT)
    @ResponseBody
    public SzpJsonResult<String> updateById(@RequestBody UpdateByIdRequest pointRequest){
        log.info("pointId:",pointRequest.getPointId());

        boolean isSuccess = pointService.updateNameById(pointRequest);
        return SzpJsonResult.ok(isSuccess);
    }

    /**
     * 方法描述
     * @ 查询所有重点
     * @return
     * @date 2020/2/21
     */
    @ApiOperation(value = "通过章节ID查询所有重点")
    @RequestMapping(value = "/point/selectAll", method = RequestMethod.POST)
    public SzpJsonResult<SelectAllPointResponse> selectPointByCategoryId(@RequestBody CategoryIdRequest request){

        return SzpJsonResult.ok(pointService.selectPointByCategoryId(request.getCategoryId()));
    }

    @PostMapping("delete/pointByCategoryId")
    public SzpJsonResult<String> deletePointByCategoryId(@RequestBody CategoryIdRequest request){
        if (pointService.deletePointByCategoryId(request.getCategoryId())>=1){
            return SzpJsonResult.ok("成功删除");
        }
        return SzpJsonResult.ok("删除失败");
    }
}
