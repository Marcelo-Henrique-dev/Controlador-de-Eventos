package entidades;

public class Pessoa {
private String nome;
private int idade;
private double dinheiro;
private String cpf;

public Pessoa(String nome, int idade, double dinheiro, String cpf) {
    this.nome = nome;
    this.idade = idade;
    this.dinheiro = dinheiro;
    this.cpf = cpf;
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




}


