package org.example.api.dto.response;

import lombok.Data;

@Data
public class CreatePostResponseDto {
    private String redirectUrl;
    private NoticeDto notice;
    private RecordDto record;
} 