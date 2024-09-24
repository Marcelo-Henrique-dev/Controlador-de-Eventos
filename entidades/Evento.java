package entidades;

import entidades.enums.TipoEvento;

public abstract class Evento {
    private String nome;
    private String data;
    private TipoEvento tipoEvento;
    private double valorIngresso;
    private int quantidadeVagas;

    public Evento(String nome, String data, double valorIngresso, int quantidadeVagas, TipoEvento tipoEvento) {
        this.nome = nome;
        this.data = data;
        this.valorIngresso = valorIngresso;
        this.quantidadeVagas = quantidadeVagas;
        this.tipoEvento = tipoEvento;
    }

    public Evento(String nome2, String data2, String local) {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public int getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(int quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public TipoEvento getTipoEvento(){
        return this.tipoEvento;
    }
}
