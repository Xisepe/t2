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
@Table(name = "model_mapping")
public class ModelMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @Size(max = 128)
    @Column(name = "name", length = 128)
    private String name;

    @OneToMany(mappedBy = "modelMapping")
    @OrderBy("mappingColumnOrdinal")
    private Set<ColumnMapping> columnMappings = new LinkedHashSet<>();

}