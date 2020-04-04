package com.kaini.teachingmanager.request;

import lombok.Data;

import java.util.List;

@Data
public class IdsListRequest {
    private List<Long> ids;
}
