package com.guilherme.GabaritoConsumer.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prova {
    private Integer id;

    private Integer numeroQuestoes;

    private LocalDate data;

    public String getDataFormatada() {
        if (this.data == null) {
            return "";
        }
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(this.data);
    }


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
