package org.example.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiEndpoint {
    PUBLISHER_CREATE("/Publisher/actions/new"),
    POST_CREATE("/Post/actions/new"),
    EDIT_POST("/Post/records/%d/edit"),
    POST_LIST("/Post/actions/list");
    private final String path;
} 