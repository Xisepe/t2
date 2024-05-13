package ru.ccfit.golubevm.springnsupractice.api.response;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.springnsupractice.core.model.ModelHistory}
 */
@Value
public class ModelHistoryDto implements Serializable {
    Integer id;
    @Size(max = 128)
    String name;
    Instant createDate;
    Set<ModelColumnHistoryDto> modelColumnHistories;
}