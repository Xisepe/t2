package ru.ccfit.golubevm.springnsupractice.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.springnsupractice.core.model.Model}
 */
@Value
public class CreateModelRequest implements Serializable {
    @Size(max = 128)
    @NotBlank
    String name;
    @Size(max = 255)
    String description;
    @Valid
    Set<CreateModelColumnRequest> modelColumns;
    @Valid
    CreateModelMappingRequest modelMapping;
}