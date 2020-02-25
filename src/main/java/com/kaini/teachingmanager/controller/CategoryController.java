package com.kaini.teachingmanager.controller;


import com.kaini.teachingmanager.common.SzpJsonResult;
import com.kaini.teachingmanager.pojo.Category;
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
    @RequestMapping(value = "/category/{name}", method = RequestMethod.POST)
    public SzpJsonResult<String> add(@PathVariable("name") String name,long lessonId) {
        return SzpJsonResult.ok(categoryService.insert(name,lessonId));
    }

    @ApiOperation(value = "更新章节名称")
    @RequestMapping(value = "/category/update{id}", method = RequestMethod.PUT)
    public SzpJsonResult<String> update(@PathVariable("id") long id, String categoryName) {
        boolean isSuccess = categoryService.update(id, categoryName);
        return SzpJsonResult.ok(isSuccess);
    }

    @ApiOperation(value = "批量删除章节")
    @RequestMapping(value = "/category/deleteSome", method = RequestMethod.POST)
    public SzpJsonResult<String> remove(@RequestBody List<Long> ids) {
        Integer integer = categoryService.remove(ids);
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
    public List<Category> selectCateByLessonId(@RequestBody Long lessonId){
        return categoryService.selectCateByLessonId(lessonId);
    }

    /**
     * 方法描述
     * @ 通过lessonId删除
     * @return
     * @date 2020/2/25
     */
    @ApiOperation(value ="通过lessonId删除")
    @DeleteMapping("delete/CategoryByLessonId")
    public SzpJsonResult<String> removeCategoryByLessonId(Long lessonId){
        if (categoryService.removeCategoryByLessonId(lessonId)==1){
            return SzpJsonResult.ok("成功删除");
        }
        return SzpJsonResult.ok("删除失败");
    }

}
