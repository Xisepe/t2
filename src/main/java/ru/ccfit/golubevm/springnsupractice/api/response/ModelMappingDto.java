package ru.ccfit.golubevm.springnsupractice.api.response;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.springnsupractice.core.model.ModelMapping}
 */
@Value
public class ModelMappingDto implements Serializable {
    Integer id;
    @Size(max = 128)
    String name;
    Set<ColumnMappingDto> columnMappings;
}