package ru.ccfit.golubevm.springnsupractice.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.springnsupractice.core.model.ModelMapping}
 */
@Data
@NoArgsConstructor
public class CreateModelMappingRequest implements Serializable {
    @Size(max = 128)
    @NotBlank
    private String name;
}