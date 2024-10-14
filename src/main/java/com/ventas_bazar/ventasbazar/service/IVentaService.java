package com.ventas_bazar.ventasbazar.service;

import java.util.List;

import com.ventas_bazar.ventasbazar.model.Venta;
import java.time.LocalDate;

public interface IVentaService {

    void save(Venta v);

    void deletById(Long id);

    void edit(Venta v);

    List<Venta> findAll();

    Venta findById(Long id);

    List<Venta> findByFechaVenta(LocalDate fecha);
}
