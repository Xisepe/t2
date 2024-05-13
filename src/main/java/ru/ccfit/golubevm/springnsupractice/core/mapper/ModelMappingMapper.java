package ru.ccfit.golubevm.springnsupractice.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.springnsupractice.api.request.CreateColumnMappingRequest;
import ru.ccfit.golubevm.springnsupractice.api.request.CreateModelColumnRequest;
import ru.ccfit.golubevm.springnsupractice.api.request.CreateModelMappingRequest;
import ru.ccfit.golubevm.springnsupractice.api.response.ColumnMappingDto;
import ru.ccfit.golubevm.springnsupractice.api.response.ModelMappingDto;
import ru.ccfit.golubevm.springnsupractice.core.model.ColumnMapping;
import ru.ccfit.golubevm.springnsupractice.core.model.ModelColumn;
import ru.ccfit.golubevm.springnsupractice.core.model.ModelMapping;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ModelMappingMapper {
    ColumnMapping toModelColumn(CreateColumnMappingRequest request);
    ModelMapping toModelMapping(CreateModelMappingRequest request);
    @AfterMapping
    default void linkModelColumnWithModel(@MappingTarget ModelMapping modelMapping) {
        modelMapping.getColumnMappings().forEach(e->e.setModelMapping(modelMapping));
    }
    ModelMappingDto toModelMappingDto(ModelMapping modelMapping);
    ColumnMappingDto toColumnMappingDto(ColumnMapping columnMapping);
}
