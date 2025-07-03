package org.example.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditPostRequestDto {
    private int id;
    private String createAt;
    private String updatedAt;
    private String someJson;
    private String title;
    @Builder.Default
    private String content = "default-content";
    @Builder.Default
    private String status = "ACTIVE";
    @Builder.Default
    private Boolean published = true;
    private int publisher;
} 