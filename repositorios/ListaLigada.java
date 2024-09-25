package repositorios;

import entidades.Elemento;

public class ListaLigada {
    private Elemento primeiro;
    private Elemento ultimo;
    private int tamanho;

    public ListaLigada(){
        this.tamanho = 0;
    }

    public Elemento getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(Elemento primeiro) {
        this.primeiro = primeiro;
    }
    public Elemento getUltimo() {
        return ultimo;
    }
    public void setUltimo(Elemento ultimo) {
        this.ultimo = ultimo;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Elemento get(int posicao){
        Elemento atual = this.primeiro;
        for(int i=0; i<posicao; i++){
            if(atual.getProximo() != null){
                atual = atual.getProximo();
            }
        }
        return atual;
    }

    public boolean isEmpty(){
        if(getTamanho() == 0){
            return true;
        }else{
            return false;
        }
    }
}
