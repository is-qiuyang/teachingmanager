package com.kaini.teachingmanager.controller;

import com.kaini.teachingmanager.common.SzpJsonResult;
import com.kaini.teachingmanager.pojo.Lesson;
import com.kaini.teachingmanager.request.AddLessonRequest;
import com.kaini.teachingmanager.request.GetAllLessonRequest;
import com.kaini.teachingmanager.request.IdsListRequest;
import com.kaini.teachingmanager.request.SelectLikeLessonRequest;
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
    public SzpJsonResult<Lesson> getAllLesson(@RequestBody GetAllLessonRequest getAllLessonRequest) {
        return SzpJsonResult.ok(lessonService.findAllLesson(getAllLessonRequest));
    }
    
    /**
     * 方法描述
     * @ 插入课程
     * @return 
     * @date 2020/2/14
     */
    @ApiOperation(value = "插入课程")
    @PostMapping("insert/test")
    public SzpJsonResult<String> insertLesson(@RequestBody AddLessonRequest lessonRequest){

        if (lessonService.insertLesson(lessonRequest).equals(1)){
            return SzpJsonResult.ok("添加课程成功");
        }else {
            return SzpJsonResult.errorMsg("添加课程失败，请重新添加");
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
    public SzpJsonResult<String> deleteAllLesson(@RequestBody IdsListRequest request){
        Integer integer = lessonService.deleteAllLesson(request.getIds());
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
    public SzpJsonResult<List<Lesson>> selectLikeLesson(@RequestBody SelectLikeLessonRequest  request){
        List<Lesson> lessons = lessonService.selectLikeLesson(request.getType());
        return SzpJsonResult.ok(lessons);
    }
}
