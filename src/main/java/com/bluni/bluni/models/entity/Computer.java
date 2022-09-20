package com.bluni.bluni.models.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@ToString
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String procesador;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String color;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String ram;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String board;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String disco_duro;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String grafica;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String marca;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "ubicaciones_id")
    private Ubication ubication;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String mac;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String modelo;

    @Column
    @Getter
    @Setter
    @NotEmpty
    private String tipo;
}
