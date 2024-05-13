package ru.ccfit.golubevm.springnsupractice.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "column_mapping")
public class ColumnMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "mapping_column_name", nullable = false)
    private String mappingColumnName;

    @NotNull
    @Column(name = "mapping_column_ordinal", nullable = false)
    private Integer mappingColumnOrdinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_mapping_id")
    private ModelMapping modelMapping;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_column_id")
    private ModelColumn modelColumn;

}