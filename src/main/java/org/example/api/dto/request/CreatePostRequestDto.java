package org.example.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePostRequestDto {
    @Builder.Default
    private String title = "default-title";
    @Builder.Default
    private String content = "default-content";
    @Builder.Default
    private String status = "ACTIVE";
    @Builder.Default
    private Boolean published = true;

    private int publisher;
} 