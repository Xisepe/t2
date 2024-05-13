package ru.ccfit.golubevm.springnsupractice.api.request;

import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.springnsupractice.core.model.ColumnMapping}
 */
@Value
public class CreateColumnMappingRequest implements Serializable {
    @Size(max = 255)
    @NotBlank
    String mappingColumnName;
    @PositiveOrZero
    @NotNull
    Integer mappingColumnOrdinal;
}