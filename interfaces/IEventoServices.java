package interfaces;

import exceptions.InvalidEventoTypeException;

public interface IEventoServices {
    public void cadastrarEventoNoRepositorio() throws InvalidEventoTypeException;
    public void listarEventos();
    public void editarEventos();
    public void apagarEvento();
}
