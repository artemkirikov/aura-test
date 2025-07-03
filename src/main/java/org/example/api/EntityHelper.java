package org.example.api;

import org.example.api.dto.request.CreatePostRequestDto;
import org.example.api.dto.request.CreatePublisherRequestDto;
import org.example.api.dto.response.CreatePublisherResponseDto;
import org.example.api.dto.response.CreatePostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.UUID;

@Component
public class EntityHelper {

    @Autowired
    private ApiClient apiClient;

    public CreatePublisherResponseDto createPublisher() {
        var request = CreatePublisherRequestDto.builder().build();
        var response = apiClient.post(ApiEndpoint.PUBLISHER_CREATE.getPath(), request);
        assertThat(response.getStatusCode()).isEqualTo(200);

        CreatePublisherResponseDto publisherResponseDto = response.as(CreatePublisherResponseDto.class);

        assertThat(publisherResponseDto.getNotice()).isNotNull();
        assertThat(publisherResponseDto.getNotice().getType()).isEqualToIgnoringCase("success");

        assertThat(publisherResponseDto.getRecord()).isNotNull();
        assertThat(publisherResponseDto.getRecord().getParams()).isNotNull();
        assertThat(publisherResponseDto.getRecord().getParams().getName()).isEqualTo(request.getName());
        assertThat(publisherResponseDto.getRecord().getParams().getEmail()).isEqualTo(request.getEmail());
        return publisherResponseDto;
    }

    public CreatePostResponseDto createPostAndLinkToPublisher(int publisherId) {
        var request = CreatePostRequestDto.builder().publisher(publisherId).build();
        var response = apiClient.post(ApiEndpoint.POST_CREATE.getPath(), request);
        assertThat(response.getStatusCode()).isEqualTo(200);

        CreatePostResponseDto postDtoResponse = response.as(CreatePostResponseDto.class);

        assertThat(postDtoResponse.getNotice()).isNotNull();
        assertThat(postDtoResponse.getNotice().getType()).isEqualToIgnoringCase("success");

        assertThat(postDtoResponse.getRecord()).isNotNull();
        assertThat(postDtoResponse.getRecord().getParams()).isNotNull();
        assertThat(postDtoResponse.getRecord().getParams().getTitle()).isEqualTo(request.getTitle());
        assertThat(postDtoResponse.getRecord().getParams().getContent()).isEqualTo(request.getContent());
        assertThat(postDtoResponse.getRecord().getParams().getStatus()).isEqualTo(request.getStatus());
        assertThat(postDtoResponse.getRecord().getParams().getPublished()).isEqualTo(request.getPublished());
        assertThat(postDtoResponse.getRecord().getParams().getPublisher()).isEqualTo(publisherId);
        return postDtoResponse;
    }
}
