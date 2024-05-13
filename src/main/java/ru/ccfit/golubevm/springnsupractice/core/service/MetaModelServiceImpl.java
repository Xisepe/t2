package ru.ccfit.golubevm.springnsupractice.core.service;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.springnsupractice.core.model.Model;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MetaModelServiceImpl implements MetaModelService {
    private final DSLContext ctx;

    @Override
    public void createTable(Model model) {
        ctx.createTableIfNotExists(model.getName())
                .column(Model.ID_PREFIX, SQLDataType.INTEGER.identity(true))
                .primaryKey(Model.ID_PREFIX)
                .columns(
                        model.getModelColumns()
                                .stream()
                                .map(e -> DSL.field(e.getName(), SQLDataType.VARCHAR(128)))
                                .toList()
                )
                .execute();
    }

    @Override
    public void deleteTable(Model model) {
        ctx.delete(DSL.table(model.getName()))
                .execute();
    }

    @Override
    public void upsertDataFromFile(Model model, InputStream inputStream) {
        var lines = parseFileToStrings(inputStream);
        var columns = model.getModelColumns()
                .stream()
                .map(e -> DSL.field(e.getName(), SQLDataType.VARCHAR(128)))
                .toList();
        var debug = lines.stream()
                .filter(e->e.size()!=60)
                .toList();
        var statement = ctx.insertInto(
                DSL.table(model.getName()),
                columns
        );
        for (List<String> line : lines) {
            statement = statement.values(line);
        }
        statement.execute();
    }

    private List<List<String>> parseFileToStrings(InputStream inputStream) {
        try (var buf = new BufferedReader(new InputStreamReader(inputStream))) {
            return buf.lines()
                    .parallel()
                    .map(e -> Arrays.asList(e.split(";")))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
