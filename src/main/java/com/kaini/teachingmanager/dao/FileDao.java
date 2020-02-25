package com.kaini.teachingmanager.dao;

import com.kaini.teachingmanager.mapper.FileMapper;
import com.kaini.teachingmanager.pojo.File;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class FileDao {
    @Autowired
    private FileMapper fileMapper;

    /**
     * 方法描述
     * @ 通过名字模糊查询文件
     * @return 
     * @date 2020/2/25
     */
    public List<File> findFileByName(String name){
        Example example = new Example(File.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(name)){
            criteria.andLike("name","%" + name +"%");
        }
        return fileMapper.selectByExample(example);
    }

    //通过主键批量删除文件
    public int removeById(List<Long> ids){
        Example example = new Example(File.class);
        example.createCriteria().andIn("id",ids);
        return fileMapper.deleteByExample(example);
    }


    //添加一个文件
    public boolean insertFile(File file){
        if(fileMapper.insert(file)==1){
            return true;
        }else {
            return false;
        }
    }

    //通过分类编号删除文件
    public int deleteFileByCategoryId(Long categoryId){
        Example example = new Example(File.class);
        example.createCriteria().andEqualTo("categoryId",categoryId);
        return fileMapper.deleteByExample(example);
    }

    /**
     * 方法描述
     * @ 通过分类编号查找文件
     * @return
     * @date 2020/2/25
     */
    public List<File> selectFileByCategoryId(Long categoryId){
        Example example = new Example(File.class);
        example.createCriteria().andEqualTo("categoryId",categoryId);
        return fileMapper.selectByExample(example);
    }

}
