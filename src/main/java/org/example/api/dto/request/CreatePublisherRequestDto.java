package org.example.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePublisherRequestDto {
    @Builder.Default
    private String name = UUID.randomUUID() + "_AUTO";
    @Builder.Default
    private String email = UUID.randomUUID() + "@email.com";
} 