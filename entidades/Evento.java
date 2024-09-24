package entidades;


    // Criar classe abstrata
    // atriburos padrões: nome do evento, data do evento, valor do ingresso, quantidade de vagas

public abstract class Evento {
    private String nome;
    private String data;
    private double valorIngresso;
    private int quantidadeVagas;

    public Evento(String nome, String data, double valorIngresso, int quantidadeVagas) {
        this.nome = nome;
        this.data = data;
        this.valorIngresso = valorIngresso;
        this.quantidadeVagas = quantidadeVagas;
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
}
