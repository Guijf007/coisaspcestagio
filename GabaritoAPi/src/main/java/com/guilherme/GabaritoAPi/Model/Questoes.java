package com.guilherme.GabaritoAPi.Model;

import jakarta.persistence.*;

@Entity
public class Questoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_prova")
    private Integer idProva;

    private Integer tipo;

    private Integer somatoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getSomatoria() {
        return somatoria;
    }

    public void setSomatoria(Integer somatoria) {
        this.somatoria = somatoria;
    }
}
