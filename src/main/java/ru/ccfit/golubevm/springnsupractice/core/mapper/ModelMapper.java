package ru.ccfit.golubevm.springnsupractice.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.springnsupractice.api.request.CreateModelColumnRequest;
import ru.ccfit.golubevm.springnsupractice.api.request.CreateModelRequest;
import ru.ccfit.golubevm.springnsupractice.api.response.ModelColumnDto;
import ru.ccfit.golubevm.springnsupractice.api.response.ModelDto;
import ru.ccfit.golubevm.springnsupractice.core.model.Model;
import ru.ccfit.golubevm.springnsupractice.core.model.ModelColumn;

import java.util.LinkedHashSet;
import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {
                ModelMappingMapper.class,
                ModelHistoryMapper.class
        }
)
public interface ModelMapper {
    Model toModel(CreateModelRequest createModelRequest);

    @AfterMapping
    default void linkEntityToColumns(@MappingTarget Model model) {
        if (model.getModelMapping() != null) {
            model.getModelMapping().setModel(model);
        }

        if (model.getModelColumns() == null) {
            model.setModelColumns(new LinkedHashSet<>());
        }
        model.getModelColumns().forEach(e -> {
            e.setModel(model);
            if (e.getColumnMapping() != null) {
                e.getColumnMapping().setModelColumn(e);
            }
        });
    }

    ModelDto toModelDto(Model model);

    List<ModelDto> toModelDtos(List<Model> models);

    ModelColumn toModelColumn(CreateModelColumnRequest request);

    ModelColumnDto toModelColumnDto(ModelColumn modelColumn);

}
