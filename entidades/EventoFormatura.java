package entidades;

import entidades.enums.TipoEvento;

public class EventoFormatura extends Evento {
    
    private String curso;

    public EventoFormatura(String nome, String data, double valorIngresso, int quantidadeVagas, String curso) {
        super(nome, data, valorIngresso, quantidadeVagas, TipoEvento.EVENTOFORMATURA);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}
