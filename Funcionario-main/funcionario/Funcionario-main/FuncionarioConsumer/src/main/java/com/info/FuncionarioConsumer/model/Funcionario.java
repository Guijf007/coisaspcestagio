package com.info.FuncionarioConsumer.model;

import java.text.NumberFormat;
import java.util.Locale;

public class Funcionario {
    private Integer id = 0;
    private String nome;
    private Boolean vt;
    private Integer dep14;
    private Integer depir;
    private Double salbase;

    public String getTipoTexto(){
        return vt==false?"Não":"Sim";
    }

    public String getSalBaseTotalSemiFormatado(){
        return salbase + "";
    }

    public void setSalBaseTotalSemiFormatado(String salBaseTotalSemiFormatado){
        salbase = Double.parseDouble(salBaseTotalSemiFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getSalBaseTotalFormatado() {
        if(salbase == 0){
            return "R$ 0,00";
        }
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(salbase);
    }

    public void setSalBaseTotalFormatado(String salBaseFormatado) {
        salbase = Double.parseDouble(salBaseFormatado.substring(3).replace(".", "").replace(",", "."));
    }

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
