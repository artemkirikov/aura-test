package org.example.api.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class ListResponseDto {
    private MetaDto meta;
    private List<RecordDto> records;
} 