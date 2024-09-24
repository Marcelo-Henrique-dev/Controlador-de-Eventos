package repositorios;

import java.util.LinkedList;

import entidades.Evento;

public class RepositorioDeEventos{

    private LinkedList<Evento> eventos;

    public RepositorioDeEventos(){
        this.eventos = new LinkedList<Evento>();
    }

    public LinkedList<Evento> ListarEventos(){
        return this.eventos;
    }
}
