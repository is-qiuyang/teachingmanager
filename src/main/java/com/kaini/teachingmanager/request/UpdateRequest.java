package com.kaini.teachingmanager.request;

import lombok.Data;

@Data
public class UpdateRequest {
    private Long id;
    private String categoryName;
}
