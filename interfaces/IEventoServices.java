package interfaces;

import entidades.Evento;

public interface IEventoServices {
    public void cadastrarEventoNoRepositorio();
    public Evento listarEventos();
    public void editarEventos();
    public void apagarEvento();
}
