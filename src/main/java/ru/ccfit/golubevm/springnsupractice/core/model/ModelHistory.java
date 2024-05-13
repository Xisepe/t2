package ru.ccfit.golubevm.springnsupractice.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "model_history")
public class ModelHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @Size(max = 128)
    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "create_date")
    private Instant createDate;

    @OneToMany(mappedBy = "modelHistory", cascade = CascadeType.ALL)
    private Set<ModelColumnHistory> modelColumnHistories = new LinkedHashSet<>();

}