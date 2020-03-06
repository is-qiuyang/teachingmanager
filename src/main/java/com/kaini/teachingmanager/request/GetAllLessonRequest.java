package com.kaini.teachingmanager.request;

import lombok.Data;

@Data
public class GetAllLessonRequest {
    Integer pageSize = 2 ;
    Integer pageNumber ;
}
