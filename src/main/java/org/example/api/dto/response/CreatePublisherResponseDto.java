package org.example.api.dto.response;

import lombok.Data;

@Data
public class CreatePublisherResponseDto {
    private String redirectUrl;
    private NoticeDto notice;
    private RecordDto record;
} 