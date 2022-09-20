package com.bluni.bluni.models.service;

import com.bluni.bluni.models.entity.Computer;
import com.bluni.bluni.models.entity.Ubication;

import java.util.List;

public interface IUbicationService {
    List<Ubication> ListaUbicaciones();
    public void guardar(Ubication ubication);
    public Ubication buscarPorId(Long id);
    public void eliminar(Long id);
}
