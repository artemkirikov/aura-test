package org.example.api.dto.response;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class RecordDto {
    private ParamsDto params;
    private Map<String, Object> populated;
    private Object baseError;
    private Map<String, Object> errors;
    private int id;
    private String title;
    private List<RecordActionDto> recordActions;
    private List<BulkActionDto> bulkActions;
} 