package com.ventas_bazar.ventasbazar.service;

import java.util.List;

import com.ventas_bazar.ventasbazar.model.Producto;

public interface IProductoService {
    void save(Producto p);

    void deletById(Long id);

    void edit(Producto p);

    List<Producto> findAll();

    Producto findById(Long id);

}
