package entidades;

import entidades.enums.TipoEvento;

public class EventoIgreja extends Evento {
    private String padre;

    public EventoIgreja(String nome, String data, double valorIngresso, int quantidadeVagas, String padre) {
        super(nome, data, valorIngresso, quantidadeVagas, TipoEvento.EVENTOIGREJA);
        this.padre = padre;
    }

    public String getDenominação() {
        return padre;
    }

    public void setDenominação(String padre) {
        this.padre = padre;
    }
}
