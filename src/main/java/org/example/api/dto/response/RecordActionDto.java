package org.example.api.dto.response;

import lombok.Data;

@Data
public class RecordActionDto {
    private String name;
    private String actionType;
    private String icon;
    private String label;
    private String resourceId;
    private String guard;
    private boolean showFilter;
    private boolean showResourceActions;
    private boolean showInDrawer;
    private boolean hideActionHeader;
    private Object containerWidth;
    private String layout;
    private String variant;
    private String parent;
    private boolean hasHandler;
    private Object custom;
    private Boolean component;
} 