package com.bluni.bluni.models.service;

import com.bluni.bluni.models.entity.Computer;
import com.bluni.bluni.models.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComputerServiceImplement implements IComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> listarTodos(String palabraClave) {
        if (palabraClave != null)
            return computerRepository.findAll(palabraClave);
        return computerRepository.findAll();
    }

    @Override
    public void guardar(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public Computer buscarPorId(Long id) {
        return computerRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        computerRepository.deleteById(id);
    }

}
