package com.kaini.teachingmanager.controller;


import com.kaini.teachingmanager.common.SzpJsonResult;
import com.kaini.teachingmanager.pojo.CategoryType;
import com.kaini.teachingmanager.service.CategoryTypeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryTypeController {
    @Autowired
    private CategoryTypeService categoryTypeService;

    @ApiOperation(value = "新增一个分类")
    @RequestMapping(value = "/{name}", method = RequestMethod.POST)
    public SzpJsonResult<String> add(@PathVariable("name") String name,long lessonId) {
        return SzpJsonResult.ok(categoryTypeService.insert(name,lessonId));
    }

    @ApiOperation(value = "更新分类名称")
    @RequestMapping(value = "/update{id}", method = RequestMethod.PUT)
    public SzpJsonResult<String> update(@PathVariable("id") long id, String categoryName) {
        boolean isSuccess = categoryTypeService.update(id, categoryName);
        return SzpJsonResult.ok(isSuccess);
    }

    @ApiOperation(value = "删除一个分类")
    @RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
    public SzpJsonResult<String> remove(@PathVariable("id") int id) {
        return SzpJsonResult.ok(categoryTypeService.remove(id));
    }

    @ApiOperation(value = "获取一个分类")
    @RequestMapping(value = "/getOne{id}", method = RequestMethod.GET)
    public SzpJsonResult<CategoryType> getById(@PathVariable("id") int id) {
        CategoryType category = categoryTypeService.getById(id);
        log.info("category:"+id+category);
        return SzpJsonResult.ok(categoryTypeService.getById(id));
    }

    @ApiOperation(value = "获取所有分类")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public SzpJsonResult<String> getAll() {
        return SzpJsonResult.ok(categoryTypeService.list());
    }
}
