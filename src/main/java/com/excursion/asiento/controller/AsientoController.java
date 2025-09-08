package com.excursion.asiento.controller;

import com.excursion.asiento.model.Asiento;
import com.excursion.asiento.model.ApiResponse;
import com.excursion.asiento.service.AsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/asientos")
public class AsientoController {

    @Autowired
    private AsientoService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Asiento>>> listar() {
        List<Asiento> asientos = service.listar();
        ApiResponse<List<Asiento>> response = new ApiResponse<>(200, "Lista de asientos", null, asientos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Asiento>> obtener(@PathVariable Long id) {
        try {
            Asiento asiento = service.obtener(id);
            ApiResponse<Asiento> response = new ApiResponse<>(200, "Asiento encontrado", null, asiento);
            return ResponseEntity.ok(response);
        } catch (EmptyResultDataAccessException e) {
            ApiResponse<Asiento> response = new ApiResponse<>(404, "Asiento no encontrado", null, null);
            return ResponseEntity.status(404).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Asiento>> guardar(@RequestBody Asiento a) {
        service.guardar(a);
        ApiResponse<Asiento> response = new ApiResponse<>(201, "Asiento creado", null, a);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Asiento>> actualizar(@PathVariable Long id, @RequestBody Asiento a) {
        a.setIdAsiento(id);
        service.actualizar(a);
        ApiResponse<Asiento> response = new ApiResponse<>(200, "Asiento actualizado", null, a);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        ApiResponse<Void> response = new ApiResponse<>(200, "Asiento eliminado", null, null);
        return ResponseEntity.ok(response);
    }
}