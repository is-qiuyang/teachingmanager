package com.kaini.teachingmanager.request;

import lombok.Data;

@Data
public class AddRequest {
    private String name;
    private long lessonId;

}
