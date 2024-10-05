package com.ventas_bazar.ventasbazar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas_bazar.ventasbazar.model.Producto;
import com.ventas_bazar.ventasbazar.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository repository;
    @Override
    public void save(Producto p) {
        repository.save(p);
    }

    @Override
    public void deletById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Producto p) {
        repository.save(p);
    }

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
}
