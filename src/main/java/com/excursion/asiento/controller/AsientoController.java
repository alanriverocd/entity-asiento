package com.excursion.asiento.controller;

import com.excursion.asiento.model.Asiento;
import com.excursion.asiento.service.AsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asientos")
public class AsientoController {

    @Autowired
    private AsientoService service;

    @GetMapping
    public List<Asiento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Asiento obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    public void guardar(@RequestBody Asiento a) {
        service.guardar(a);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody Asiento a) {
        a.setIdAsiento(id);
        service.actualizar(a);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}