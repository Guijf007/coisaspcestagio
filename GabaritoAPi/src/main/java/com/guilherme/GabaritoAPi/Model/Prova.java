package com.guilherme.GabaritoAPi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prova {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_questoes")
    private Integer numeroQuestoes;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroQuestoes() {
        return numeroQuestoes;
    }

    public void setNumeroQuestoes(Integer numeroQuestoes) {
        this.numeroQuestoes = numeroQuestoes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
