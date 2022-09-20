package com.bluni.bluni.models.service;

import com.bluni.bluni.models.entity.Computer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IComputerService {
    public List<Computer> listarTodos(String palabraClave);
    public void guardar(Computer computer);
    public Computer buscarPorId(Long id);
    public void eliminar(Long id);
}
