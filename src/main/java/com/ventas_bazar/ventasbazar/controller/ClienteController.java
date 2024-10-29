package com.ventas_bazar.ventasbazar.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ventas_bazar.ventasbazar.model.Cliente;
import com.ventas_bazar.ventasbazar.service.IClienteService;

import java.util.List;

@RestController
public class ClienteController {
     @Autowired
    private IClienteService service;

    @GetMapping("/cliente/todos")
    public List<Cliente> getAllCliente() {
        return service.findAll();
    }

    @PostMapping("/cliente/crear")
    public String crearCliente(@Valid @RequestBody Cliente cliente) {
        service.save(cliente);
        return "cliente creado";
    }

    @PutMapping("/cliente/editar/{id}")
    public String editarCliente(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
        service.save(cliente);
        return "cliente modificado";
    }

    @DeleteMapping("/cliente/borrar/{id}")
    public String borrarClienteById(@PathVariable Long id) {
        service.deletById(id);
        return "cliente eliminado";
    }
    @GetMapping("/cliente/traer/{id}")
    public Cliente getVentaById(@PathVariable Long id) {
        return service.findById(id);
    }
}
