package com.info.funcionarioAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = 0;
    private String nome;
    private Boolean vt;
    private Integer dep14;
    private Integer depir;
    private Double salbase;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getVt() {
        return vt;
    }

    public void setVt(Boolean vt) {
        this.vt = vt;
    }

    public Integer getDep14() {
        return dep14;
    }

    public void setDep14(Integer dep14) {
        this.dep14 = dep14;
    }

    public Integer getDepir() {
        return depir;
    }

    public void setDepir(Integer depir) {
        this.depir = depir;
    }

    public Double getSalbase() {
        return salbase;
    }

    public void setSalbase(Double salbase) {
        this.salbase = salbase;
    }
}
