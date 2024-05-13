package ru.ccfit.golubevm.springnsupractice.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.springnsupractice.core.model.ModelColumn}
 */
@Value
public class CreateModelColumnRequest implements Serializable {
    @Size(max = 255)
    String displayName;
    @Size(max = 64)
    String type;
    @Valid
    CreateColumnMappingRequest columnMapping;
}