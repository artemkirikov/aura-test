package org.example.api.dto.response;

import lombok.Data;

@Data
public class ParamsDto {
    private int id;
    private String email;
    private String name;
    private String title;
    private String content;
    private String status;
    private Boolean published;
    private String createdAt;
    private String updatedAt;
    private Object someJson;
    private Integer publisher;
} 