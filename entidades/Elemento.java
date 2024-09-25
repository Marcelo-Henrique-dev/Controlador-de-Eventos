package entidades;

public class Elemento {
    private Evento valor;
    private Elemento proximo;
    
    public Evento getValor() {
        return valor;
    }
    public void setValor(Evento valor) {
        this.valor = valor;
    }
    public Elemento getProximo() {
        return proximo;
    }
    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }
}
