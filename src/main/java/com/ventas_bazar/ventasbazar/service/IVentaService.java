package com.ventas_bazar.ventasbazar.service;

import java.util.List;

import com.ventas_bazar.ventasbazar.model.Venta;

public interface IVentaService {

    void save(Venta v);

    void deletById(Long id);

    void edit(Venta v);

    List<Venta> findAll();

    Venta findById(Long id);
}
