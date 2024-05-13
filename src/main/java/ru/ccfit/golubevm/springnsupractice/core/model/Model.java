package ru.ccfit.golubevm.springnsupractice.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "model", indexes = {
        @Index(name = "idx_model_name", columnList = "name")
})
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 128)
    @Column(name = "name", length = 128)
    private String name;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private Set<ModelColumn> modelColumns = new LinkedHashSet<>();

    @OneToOne(mappedBy = "model", cascade = CascadeType.ALL)
    private ModelMapping modelMapping;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private Set<ModelHistory> modelHistories = new LinkedHashSet<>();

    @Transient
    private boolean namesPopulated = false;
    @Transient
    public static final String ID_PREFIX = "_id_";
    public void populateNamesOfColumns() {
        int i = 0;
        if (namesPopulated || modelColumns == null || modelColumns.isEmpty()) {
            return;
        }
        for (var modelColumn : modelColumns) {
            modelColumn.buildColumnName(i++);
        }
        namesPopulated = true;
    }

}