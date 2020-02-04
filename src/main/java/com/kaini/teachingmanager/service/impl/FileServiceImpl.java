package com.kaini.teachingmanager.service.impl;

import com.kaini.teachingmanager.dao.FileDao;
import com.kaini.teachingmanager.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;




}
