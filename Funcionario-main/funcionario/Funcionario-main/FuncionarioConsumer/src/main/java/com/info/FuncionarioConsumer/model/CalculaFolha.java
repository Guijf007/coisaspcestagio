package com.info.FuncionarioConsumer.model;

import java.text.NumberFormat;
import java.util.Locale;

public class CalculaFolha {
    private Funcionario funcionario;
    private Tabelas tabela;
    private double inss;
    private double sf;
    private double vt;
    private double salliq;
    private double irrf;
    private double totalv;
    private double totald;//Encapsular os campos agora
    double p;

    public void calcula() {
//Cálculo do Vale Transporte
        if (funcionario.getVt().equals(true)) {
            vt = funcionario.getSalbase() * 6 / 100;
        } else {
            vt = 0;
        }
//Cálculo do Salário Família
        if (funcionario.getSalbase() <= tabela.getTsf()) {
            sf = funcionario.getDep14() * tabela.getVsf();
        } else {
            sf = 0;
        }
        //Cálculo do INSS
        if (funcionario.getSalbase() <= tabela.getTinss1()) {
            inss = funcionario.getSalbase() * tabela.getAinss1() / 100;
        } else {
            p = tabela.getTinss1() * tabela.getAinss1() / 100;
            if (funcionario.getSalbase() <= tabela.getTinss2()) {
                inss = p + (funcionario.getSalbase() - tabela.getTinss1()) * tabela.getAinss2() / 100;
            } else {
                p = p + (tabela.getTinss2() - tabela.getTinss1()) * tabela.getAinss2() / 100;
                if (funcionario.getSalbase() <= tabela.getTinss3()) {
                    inss = p + (funcionario.getSalbase() - tabela.getTinss2()) * tabela.getAinss3() / 100;
                } else {
                    p = p + (tabela.getTinss3() - tabela.getTinss2()) * tabela.getAinss3() / 100;
                    if (funcionario.getSalbase() <= tabela.getTinss4()) {
                        inss = p + (funcionario.getSalbase() - tabela.getTinss3()) * tabela.getAinss4() / 100;
                    } else {
                        inss = p + (tabela.getTinss4() - tabela.getTinss3()) * tabela.getAinss4() / 100;
                    }
                }
            }
        }
//Cálculo do IRRF
        double bc = funcionario.getSalbase() - inss - (funcionario.getDepir() * tabela.getDedpdep());
        if (bc <= tabela.getTirrf1()) {
            irrf = 0;
        } else {
            if (bc <= tabela.getTirrf2()) {
                irrf = bc * (tabela.getAirrf2() / 100) - tabela.getDirrf2();
            } else {
                if (bc <= tabela.getTirrf3()) {
                    irrf = bc * (tabela.getAirrf3() / 100) - tabela.getDirrf3();
                } else {
                    if (bc <= tabela.getTirrf4()) {
                        irrf = bc * (tabela.getAirrf4() / 100) - tabela.getDirrf4();
                    } else {
                        irrf = bc * (tabela.getAirrf5() / 100) - tabela.getDirrf5();
                    }
                }
            }
        }
//Cálculo do Salário Líquido
        salliq = funcionario.getSalbase() - inss + sf - vt - irrf;
        totalv = funcionario.getSalbase() + sf;
        totald = inss + vt + irrf;
    }

    public String getInssTotalSemiFormatado(){
        return inss + "";
    }

    public void setInssTotalSemiFormatado(String inssTotalSemiFormatado){
        inss = Double.parseDouble(inssTotalSemiFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getInssTotalFormatado() {
        if(inss == 0){
            return "R$ 0,00";
        }
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(inss);
    }

    public void setInssTotalFormatado(String inssFormatado) {
        inss = Double.parseDouble(inssFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getSfTotalSemiFormatado(){
        return sf + "";
    }

    public void setSfTotalSemiFormatado(String sfTotalSemiFormatado){
        sf = Double.parseDouble(sfTotalSemiFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getSfTotalFormatado() {
        if(sf == 0){
            return "R$ 0,00";
        }
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(sf);
    }

    public void setSfTotalFormatado(String sfFormatado) {
        sf = Double.parseDouble(sfFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getVtTotalSemiFormatado(){
        return vt + "";
    }

    public void setVtTotalSemiFormatado(String vtTotalSemiFormatado){
        vt = Double.parseDouble(vtTotalSemiFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getVtTotalFormatado() {
        if(vt == 0){
            return "R$ 0,00";
        }
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(vt);
    }

    public void setVtTotalFormatado(String vtFormatado) {
        vt = Double.parseDouble(vtFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getSalliqTotalSemiFormatado(){
        return salliq + "";
    }

    public void setSalliqTotalSemiFormatado(String salliqTotalSemiFormatado){
        salliq = Double.parseDouble(salliqTotalSemiFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getSalliqTotalFormatado() {
        if(salliq == 0){
            return "R$ 0,00";
        }
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(salliq);
    }

    public void setSalliqTotalFormatado(String salliqFormatado) {
        salliq = Double.parseDouble(salliqFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getIrrfTotalSemiFormatado(){
        return irrf + "";
    }

    public void setIrrfTotalSemiFormatado(String irrfTotalSemiFormatado){
        irrf = Double.parseDouble(irrfTotalSemiFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getIrrfTotalFormatado() {
        if(irrf == 0){
            return "R$ 0,00";
        }
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(irrf);
    }

    public void setIrrfTotalFormatado(String irrfFormatado) {
        irrf = Double.parseDouble(irrfFormatado.substring(3).replace(".", "").replace(",", "."));
    }

//TotalVencimentos
    public String getTotalvTotalSemiFormatado(){
        return totalv + "";
    }

    public void setTotalvTotalSemiFormatado(String totalvTotalSemiFormatado){
        totalv = Double.parseDouble(totalvTotalSemiFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getTotalvTotalFormatado() {
        if(totalv == 0){
            return "R$ 0,00";
        }
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(totalv);
    }

    public void setTotalvTotalFormatado(String totalvFormatado) {
        totalv = Double.parseDouble(totalvFormatado.substring(3).replace(".", "").replace(",", "."));
    }

//TotalDescontos
    public String getTotaldTotalSemiFormatado(){
        return totald + "";
    }

    public void setTotaldTotalSemiFormatado(String totaldTotalSemiFormatado){
        totald = Double.parseDouble(totaldTotalSemiFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public String getTotaldTotalFormatado() {
        if(totald == 0){
            return "R$ 0,00";
        }
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(totald);
    }

    public void setTotaldTotalFormatado(String totaldFormatado) {
        totald = Double.parseDouble(totaldFormatado.substring(3).replace(".", "").replace(",", "."));
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Tabelas getTabela() {
        return tabela;
    }

    public void setTabela(Tabelas tabela) {
        this.tabela = tabela;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getSf() {
        return sf;
    }

    public void setSf(double sf) {
        this.sf = sf;
    }

    public double getVt() {
        return vt;
    }

    public void setVt(double vt) {
        this.vt = vt;
    }

    public double getSalliq() {
        return salliq;
    }

    public void setSalliq(double salliq) {
        this.salliq = salliq;
    }

    public double getIrrf() {
        return irrf;
    }

    public void setIrrf(double irrf) {
        this.irrf = irrf;
    }

    public double getTotalv() {
        return totalv;
    }

    public void setTotalv(double totalv) {
        this.totalv = totalv;
    }

    public double getTotald() {
        return totald;
    }

    public void setTotald(double totald) {
        this.totald = totald;
    }
}
