package com.kaini.teachingmanager.dao;

import com.kaini.teachingmanager.mapper.FileMapper;
import com.kaini.teachingmanager.pojo.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

@Repository
public class FileDao {
    @Autowired
    private FileMapper fileMapper;

    //通过主键获得文件
    public File selectAllFile(int id){
        return fileMapper.selectByPrimaryKey(id);
    }

    public File findFileByName(String name){
        Example example = new Example(File.class);
        example.createCriteria().andEqualTo("name",name);
        return fileMapper.selectOneByExample(example);
    }

    //通过主键删除文件
    public int removeById(int id){
        return fileMapper.deleteByPrimaryKey(id);
    }


    //添加一个文件
    public boolean insertFile(File file){
        if(fileMapper.insert(file)==1){
            return true;
        }else {
            return false;
        }
    }

    //通过用户id删除一个文件
    public int deleteFileByUserId(int userId){
        Example example = new Example(File.class);
        example.createCriteria().andEqualTo(userId);
        return fileMapper.deleteByExample(example);
    }

    //通过分类编号删除一个文件
    public int deleteFileByCategoryId(int categoryId){
        Example example = new Example(File.class);
        example.createCriteria().andEqualTo(categoryId);
        return fileMapper.deleteByExample(example);
    }

}
