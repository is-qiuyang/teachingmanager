package com.kaini.teachingmanager.controller;


import com.kaini.teachingmanager.common.SzpJsonResult;
import com.kaini.teachingmanager.pojo.Category;
import com.kaini.teachingmanager.request.AddRequest;
import com.kaini.teachingmanager.request.IdsListRequest;
import com.kaini.teachingmanager.request.SelectCateByLessonIdRequest;
import com.kaini.teachingmanager.request.UpdateRequest;
import com.kaini.teachingmanager.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "新增一个章节")
    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public SzpJsonResult<String> add(@RequestBody AddRequest request) {
        return SzpJsonResult.ok(categoryService.insert(request.getName(),request.getLessonId()));
    }

    @ApiOperation(value = "更新章节名称")
    @RequestMapping(value = "/category/update", method = RequestMethod.PUT)
    public SzpJsonResult<String> update(@RequestBody UpdateRequest request) {
        boolean isSuccess = categoryService.update(request.getId(), request.getCategoryName());
        return SzpJsonResult.ok(isSuccess);
    }

    @ApiOperation(value = "批量删除章节")
    @RequestMapping(value = "/category/deleteSome", method = RequestMethod.POST)
    public SzpJsonResult<String> remove(@RequestBody IdsListRequest request) {
        Integer integer = categoryService.remove(request.getIds());
        if (integer>0){
            return SzpJsonResult.ok("成功删除"+integer+"个章节");
        }
        return SzpJsonResult.ok("删除失败");

    }

    /**
     * 方法描述
     * @ 通过课程ID查询章节
     * @return
     * @date 2020/2/19
     */
    @ApiOperation(value = "通过课程ID查询所有章节")
    @RequestMapping(value = "/category/selectAll", method = RequestMethod.POST)
    public List<Category> selectCateByLessonId(@RequestBody SelectCateByLessonIdRequest request){
        return categoryService.selectCateByLessonId(request.getLessonId());
    }

    /**
     * 方法描述
     * @ 通过lessonId删除
     * @return
     * @date 2020/2/25
     */
    @ApiOperation(value ="通过lessonId删除")
    @PostMapping("delete/CategoryByLessonId")
    public SzpJsonResult<String> removeCategoryByLessonId(@RequestBody SelectCateByLessonIdRequest request){
        Integer integer = categoryService.removeCategoryByLessonId(request.getLessonId());
        if (integer>=1){
            return SzpJsonResult.ok("成功删除"+integer+"个章节");
        }
        return SzpJsonResult.ok("删除失败");
    }

}
