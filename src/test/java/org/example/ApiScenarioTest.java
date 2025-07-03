package org.example;

import org.example.api.ApiClient;
import org.example.api.ApiEndpoint;
import org.example.api.EntityHelper;
import org.example.api.dto.request.EditPostRequestDto;
import org.example.api.dto.response.CreatePostResponseDto;
import org.example.api.dto.response.ListResponseDto;
import org.example.api.dto.response.RecordDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiScenarioTest extends BaseApiTest {

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private EntityHelper entityHelper;

    @Test
    public void createPublisher() {
        var publisherId = entityHelper.createPublisher().getRecord().getParams().getId();
        var post = entityHelper.createPostAndLinkToPublisher(publisherId);
        var request = EditPostRequestDto.builder()
                .id(post.getRecord().getParams().getId())
                .published(true)
                .createAt(post.getRecord().getParams().getCreatedAt())
                .updatedAt(post.getRecord().getParams().getUpdatedAt())
                .publisher(publisherId)
                .title(post.getRecord().getParams().getTitle())
                .content(post.getRecord().getParams().getContent())
                .build();

        var response = apiClient.put(String.format(ApiEndpoint.EDIT_POST.getPath(), post.getRecord().getParams().getId()), request);
        assertThat(response.getStatusCode()).isEqualTo(200);
        CreatePostResponseDto postDtoResponse = response.as(CreatePostResponseDto.class);

        assertThat(postDtoResponse.getNotice()).isNotNull();
        assertThat(postDtoResponse.getNotice().getType()).isEqualToIgnoringCase("success");

        var recordParams = postDtoResponse.getRecord().getParams();
        assertThat(postDtoResponse.getRecord()).isNotNull();
        assertThat(recordParams).isNotNull();
        assertThat(recordParams.getTitle()).isEqualTo(request.getTitle());
        assertThat(recordParams.getContent()).isEqualTo(request.getContent());
        assertThat(recordParams.getStatus()).isEqualTo(request.getStatus());
        assertThat(recordParams.getPublished()).isEqualTo(request.getPublished());
        assertThat(recordParams.getPublisher()).isEqualTo(publisherId);

        var postsList = apiClient.get(ApiEndpoint.POST_LIST.getPath()).as(ListResponseDto.class);
        assertThat(postsList.getRecords()).isNotNull().isNotEmpty();
        assertThat(postsList.getRecords().stream()
                .filter(r -> r.getParams().getId() == recordParams.getId()))
                .isNotNull();
    }
} 