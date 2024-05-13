package ru.ccfit.golubevm.springnsupractice.api.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.springnsupractice.core.model.ColumnMapping}
 */
@Value
public class ColumnMappingDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 255)
    String mappingColumnName;
    @NotNull
    Integer mappingColumnOrdinal;
}