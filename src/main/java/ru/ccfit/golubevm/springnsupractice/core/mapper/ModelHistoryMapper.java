package ru.ccfit.golubevm.springnsupractice.core.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ccfit.golubevm.springnsupractice.api.response.ModelColumnHistoryDto;
import ru.ccfit.golubevm.springnsupractice.api.response.ModelHistoryDto;
import ru.ccfit.golubevm.springnsupractice.core.model.ModelColumn;
import ru.ccfit.golubevm.springnsupractice.core.model.ModelHistory;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ModelHistoryMapper {
    ModelHistoryDto toModelHistoryDto(ModelHistory modelHistory);
    ModelColumnHistoryDto toModelColumnHistoryDto(ModelColumn modelColumn);

}
