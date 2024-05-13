package ru.ccfit.golubevm.springnsupractice.core.service;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.springnsupractice.core.model.Model;
import ru.ccfit.golubevm.springnsupractice.core.repository.ModelRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final MetaModelService metaModelService;
    private final DSLContext ctx;

    @Override
    public List<Model> getModels() {
        return modelRepository.findAll();
    }

    @Override
    public Model getModel(Integer id) {
        return modelRepository.findById(id).orElseThrow();
    }

    @Override
    public Model createModel(Model model) {
        model.populateNamesOfColumns();
        var saved = modelRepository.save(model);
        metaModelService.createTable(saved);
        return saved;
    }

    @Override
    public void deleteModel(Integer id) {
        modelRepository.deleteById(id);
    }

    @Override
    public void saveFromFile(File file, Integer modelId) {
//        var model = getModel(modelId);
//        var mapping = getModel(modelId)
//                .getModelMapping()
//                .getColumnMappings();
//        try {
//            var data = Files.readAllLines(file.toPath())
//                    .parallelStream()
//                    .map(e -> e.split(","))
//                    .toList();
//            var expr = ctx.insertInto(DSL.table(model.getName()));
//
//            for (String[] datum : data) {
//                expr = expr.values(
//                        Arrays.stream(datum).map(e->DSL.field())
//                )
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
