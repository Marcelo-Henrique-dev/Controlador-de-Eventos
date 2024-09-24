package entidades;

import entidades.enums.TipoEvento;

public class EventoFeriado extends Evento {
    private String motivo;

    public EventoFeriado(String nome, String data, String motivo, double valorIngresso, int quantidadeVagas) {
        super(nome, data, valorIngresso, quantidadeVagas, TipoEvento.EVENTOFERIADO);
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
