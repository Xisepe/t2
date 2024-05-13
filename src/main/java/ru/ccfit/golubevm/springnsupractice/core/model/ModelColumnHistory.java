package ru.ccfit.golubevm.springnsupractice.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "model_column_history")
public class ModelColumnHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_column_id")
    private ModelColumn modelColumn;

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

    @Column(name = "create_date")
    private Instant createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_history_id")
    private ModelHistory modelHistory;

}