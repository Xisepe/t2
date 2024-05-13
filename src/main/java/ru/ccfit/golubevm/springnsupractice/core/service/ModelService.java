package ru.ccfit.golubevm.springnsupractice.core.service;

import ru.ccfit.golubevm.springnsupractice.core.model.Model;

import java.io.File;
import java.util.List;

public interface ModelService {
    List<Model> getModels();
    Model getModel(Integer id);
    Model createModel(Model model);
    void deleteModel(Integer id);

    void saveFromFile(File file, Integer modelId);
}
