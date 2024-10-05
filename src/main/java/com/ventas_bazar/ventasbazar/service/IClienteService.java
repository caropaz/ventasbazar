package com.ventas_bazar.ventasbazar.service;

import java.util.List;

import com.ventas_bazar.ventasbazar.model.Cliente;

public interface IClienteService {
    void save(Cliente c);
    void deletById(Long id);
    void edit(Cliente c);
    List<Cliente> findAll();
    Cliente findById(Long id);
    
} 
