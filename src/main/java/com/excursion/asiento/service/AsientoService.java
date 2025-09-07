package com.excursion.asiento.service;

import com.excursion.asiento.model.Asiento;
import com.excursion.asiento.repository.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoService {

    @Autowired
    private AsientoRepository repo;

    public List<Asiento> listar() {
        return repo.findAll();
    }

    public Asiento obtener(Long id) {
        return repo.findById(id);
    }

    public void guardar(Asiento a) {
        repo.save(a);
    }

    public void actualizar(Asiento a) {
        repo.update(a);
    }

    public void eliminar(Long id) {
        repo.delete(id);
    }
}