package com.kaini.teachingmanager.service.impl;

import com.kaini.teachingmanager.dao.FileDao;
import com.kaini.teachingmanager.pojo.File;
import com.kaini.teachingmanager.request.InsertFileRequest;
import com.kaini.teachingmanager.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;


    @Override
    public List<File> findFileByName(String name) {
        return fileDao.findFileByName(name);
    }

    @Override
    public int removeById(List<Long> ids) {
        return fileDao.removeById(ids);
    }

    @Override
    public boolean insertFile(InsertFileRequest fileRequest) {
        File file = new File();
        file.setCategoryId(fileRequest.getCategoryId());
        file.setName(fileRequest.getName());
        file.setVisitUrl(fileRequest.getVisitUrl());
        return fileDao.insertFile(file);
    }

    @Override
    public int deleteFileByCategoryId(Long categoryId) {
        return fileDao.deleteFileByCategoryId(categoryId);
    }

    @Override
    public List<File> selectFileByCategoryId(Long categoryId) {
        return fileDao.selectFileByCategoryId(categoryId);
    }
}
