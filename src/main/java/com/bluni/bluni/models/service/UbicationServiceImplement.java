package com.bluni.bluni.models.service;

import com.bluni.bluni.models.entity.Computer;
import com.bluni.bluni.models.entity.Ubication;
import com.bluni.bluni.models.repository.UbicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicationServiceImplement implements IUbicationService {
    @Autowired
    private UbicationRepository ubicationRepository;

    @Override
    public List<Ubication> ListaUbicaciones() {
        return ubicationRepository.findAll();
    }

    @Override
    public void guardar(Ubication ubication){
        ubicationRepository.save(ubication);
    }

    @Override
    public Ubication buscarPorId(Long id) {
        return ubicationRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        ubicationRepository.deleteById(id);
    }
}
