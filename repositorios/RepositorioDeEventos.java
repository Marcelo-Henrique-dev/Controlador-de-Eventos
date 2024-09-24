package repositorios;

import java.util.ArrayList;

import entidades.Evento;

public class RepositorioDeEventos {
    private ArrayList<Evento> eventos;

    public RepositorioDeEventos(){
        this.eventos = new ArrayList<Evento>();
    }

    public ArrayList<Evento> ListarEventos(){
        return this.eventos;
    }
}
