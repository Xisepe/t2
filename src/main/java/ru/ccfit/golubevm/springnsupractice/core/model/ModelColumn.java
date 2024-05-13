package ru.ccfit.golubevm.springnsupractice.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "model_column")
public class ModelColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @Size(max = 255)
    @Column(name = "display_name")
    private String displayName;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 64)
    @Column(name = "type", length = 64)
    private String type;

    @Transient
    private static final String COLUMN_NAME_PREFIX = "_col_";

    @Transient
    private boolean populated = false;

    @OneToOne(mappedBy = "modelColumn", cascade = CascadeType.ALL)
    private ColumnMapping columnMapping;

    public void buildColumnName(int ordinal) {
        if (populated) {
            return;
        }
        name = COLUMN_NAME_PREFIX + ordinal;
        populated = true;
    }
}