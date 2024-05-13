package ru.ccfit.golubevm.springnsupractice.core.service;

import ru.ccfit.golubevm.springnsupractice.core.model.Model;

import java.io.File;
import java.io.InputStream;

public interface MetaModelService {
    void createTable(Model model);
    void deleteTable(Model model);

    void upsertDataFromFile(Model model, InputStream inputStream);

}
