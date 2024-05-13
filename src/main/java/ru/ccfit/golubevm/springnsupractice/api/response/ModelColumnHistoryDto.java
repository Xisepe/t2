package ru.ccfit.golubevm.springnsupractice.api.response;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link ru.ccfit.golubevm.springnsupractice.core.model.ModelColumnHistory}
 */
@Value
public class ModelColumnHistoryDto implements Serializable {
    Integer id;
    @Size(max = 255)
    String displayName;
    @Size(max = 64)
    String type;
    Instant createDate;
}