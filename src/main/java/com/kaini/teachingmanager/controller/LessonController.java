package com.kaini.teachingmanager.controller;

import com.kaini.teachingmanager.common.SzpJsonResult;
import com.kaini.teachingmanager.pojo.Lesson;
import com.kaini.teachingmanager.request.AddLessonRequest;
import com.kaini.teachingmanager.service.LessonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LessonController {
    @Autowired
    private LessonService lessonService;
    /**
     * 方法描述
     * @ 分页查询所有课程
     * pageSize：页数大小，比如一页显示两个
     * pageNumber：查看第几页的
     * @return
     * @date 2020/2/9
     */
    @ApiOperation(value = "分页查询所有课程")
    @PostMapping("all/test")
    public SzpJsonResult<Lesson> getAllLesson(@RequestBody Integer pageSize, Integer pageNumber){
        return SzpJsonResult.ok(lessonService.findAllLesson(pageSize,pageNumber));
    }
    
    /**
     * 方法描述
     * @ 插入课程
     * @return 
     * @date 2020/2/14
     */
    @ApiOperation(value = "插入课程")
    @PostMapping("insert/test")
    public String insertLesson(@RequestBody AddLessonRequest lessonRequest){

        if (lessonService.insertLesson(lessonRequest).equals(1)){
            return "添加课程成功";
        }else {
            return "添加课程失败，请重新添加";
        }
    }

    /**
     * 方法描述
     * @ 批量删除课程
     * @return
     * @date 2020/2/15
     */
    @ApiOperation(value = " 批量删除课程")
    @PostMapping("delete/someTest")
    public SzpJsonResult<String> deleteAllLesson(@RequestBody List<Long> ids){
        Integer integer = lessonService.deleteAllLesson(ids);
        if (integer>0){
            return SzpJsonResult.ok("成功删除"+integer+"门课程");
        }
        return SzpJsonResult.ok("删除失败");
    }
    
    /**
     * 方法描述
     * @ 通过课程名模糊查询课程
     * @return 
     * @date 2020/2/15
     */
    @ApiOperation(value = "通过课程名模糊查询课程")
    @PostMapping("get/likeTest")
    public List<Lesson> selectLikeLesson(@RequestBody String type){
        return lessonService.selectLikeLesson(type);
    }
}
