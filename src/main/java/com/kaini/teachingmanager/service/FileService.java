package com.kaini.teachingmanager.service;

import com.kaini.teachingmanager.pojo.File;
import com.kaini.teachingmanager.request.InsertFileRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileService {

    /**
     * 方法描述
     * @ 通过名字模糊查询文件
     * @return
     * @date 2020/2/25
     */
    File findFileByName(String name);

    //通过主键批量删除文件
    int removeById(@Param("id") List<Long> ids);

    //添加一个文件
    boolean insertFile(InsertFileRequest fileRequest);

    //通过分类编号删除一个文件
    int deleteFileByCategoryId(int categoryId);

    /**
     * 方法描述
     * @ 通过分类编号查找文件
     * @return
     * @date 2020/2/25
     */
    List<File> selectFileByCategoryId(Long categoryId);

}
