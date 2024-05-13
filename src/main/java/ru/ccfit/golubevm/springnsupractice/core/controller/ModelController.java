package ru.ccfit.golubevm.springnsupractice.core.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ccfit.golubevm.springnsupractice.api.request.CreateModelRequest;
import ru.ccfit.golubevm.springnsupractice.api.response.ModelDto;
import ru.ccfit.golubevm.springnsupractice.core.mapper.ModelMapper;
import ru.ccfit.golubevm.springnsupractice.core.service.MetaModelService;
import ru.ccfit.golubevm.springnsupractice.core.service.ModelService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;
    private final MetaModelService metaModelService;
    private final ModelMapper mapper;

    @PostMapping("/")
    public ModelDto createModel(
            @RequestBody @Valid CreateModelRequest request
    ) {
        var model = mapper.toModel(request);
        return mapper.toModelDto(modelService.createModel(model));
    }

    @GetMapping("/")
    public List<ModelDto> getModels() {
        return mapper.toModelDtos(modelService.getModels());
    }

    @GetMapping("/{id}")
    public ModelDto getModel(@PathVariable Integer id) {
        return mapper.toModelDto(modelService.getModel(id));
    }

    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable Integer id) {
        modelService.deleteModel(id);
    }

    @PostMapping("/load")
    public boolean loadData(@RequestParam("file") MultipartFile file, @RequestParam(value = "id") @Positive Integer id) {
        var model = modelService.getModel(id);
        try {
            metaModelService.upsertDataFromFile(model, file.getInputStream());
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
