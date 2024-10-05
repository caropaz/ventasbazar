package com.ventas_bazar.ventasbazar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas_bazar.ventasbazar.model.Cliente;
import com.ventas_bazar.ventasbazar.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;
    @Override
    public void save(Cliente c) {
        clienteRepository.save(c);
    }

    @Override
    public void deletById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void edit(Cliente c) {
        clienteRepository.save(c);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    
}
