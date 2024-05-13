package ru.ccfit.golubevm.springnsupractice.api.response;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.springnsupractice.core.model.Model}
 */
@Value
public class ModelDto implements Serializable {
    Integer id;
    @Size(max = 128)
    String name;
    @Size(max = 255)
    String description;
    Set<ModelColumnDto> modelColumns;
    Set<ModelHistoryDto> modelHistories;
    ModelMappingDto modelMapping;
}