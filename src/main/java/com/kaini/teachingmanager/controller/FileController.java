package com.kaini.teachingmanager.controller;

import com.kaini.teachingmanager.common.SzpJsonResult;
import com.kaini.teachingmanager.request.InsertFileRequest;
import com.kaini.teachingmanager.response.FindFileByNameResponse;
import com.kaini.teachingmanager.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FileController {

    @Autowired
    private FileService fileService;


    /**
     * 方法描述
     * @ 通过名字模糊查询文件
     * @return
     * @date 2020/2/25
     */
    @PostMapping("file/selectByName")
    @ResponseBody
    public SzpJsonResult<FindFileByNameResponse> findFileByName(@RequestBody String name){
        return SzpJsonResult.ok(fileService.findFileByName(name));
    }

    //通过主键批量删除文件
    @DeleteMapping("delete/fileByIds")
    public SzpJsonResult<String> removeById(@RequestParam(value = "id") List<Long> ids){
        Integer integer = fileService.removeById(ids);
        if (integer>0){
            return SzpJsonResult.ok("成功删除"+integer+"个文件");
        }
        return SzpJsonResult.ok("删除失败");
    }

    //添加一个文件
    @PostMapping("file/insert")
    public SzpJsonResult<String> insertFile(@RequestBody InsertFileRequest fileRequest){
        if (fileService.insertFile(fileRequest)){
            return SzpJsonResult.ok("添加文件成功");
        }else {
            return SzpJsonResult.ok("添加文件失败，请重新添加");
        }
    }

    //通过分类编号删除一个文件
    @DeleteMapping("delete/fileByCategoryId")
    public SzpJsonResult<String> deleteFileByCategoryId(Long categoryId){
        if (fileService.deleteFileByCategoryId(categoryId)>0){
            return SzpJsonResult.ok("成功删除");
        }
        return SzpJsonResult.ok("删除失败");
    }

    /**
     * 方法描述
     * @ 通过分类编号查找文件
     * @return
     * @date 2020/2/25
     */
    @PostMapping("file/selectByCategoryId")
    public SzpJsonResult<FindFileByNameResponse> selectFileByCategoryId(Long categoryId){
        return SzpJsonResult.ok(fileService.selectFileByCategoryId(categoryId));
    }

}
