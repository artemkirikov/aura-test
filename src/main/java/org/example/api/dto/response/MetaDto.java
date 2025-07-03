package org.example.api.dto.response;

import lombok.Data;

@Data
public class MetaDto {
    private int total;
    private int perPage;
    private int page;
    private String direction;
    private String sortBy;
} 