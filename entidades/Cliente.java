package entidades;

public class Cliente {
    private String cpf;
    private String nome;
    private int idade;
    private double dinheiro;
    private String telefone;
    private int codEvento;

    public Cliente(String cpf, String nome, int idade, double dinheiro, int codEvento) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.dinheiro = dinheiro;
        this.codEvento = codEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setCodEvento(int codEvento){
        this.codEvento = codEvento;
    }

    public int getCodEvento(){
        return this.codEvento;
    }

}
