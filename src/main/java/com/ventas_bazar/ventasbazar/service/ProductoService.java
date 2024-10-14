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

    @Override
    public Integer cantidadProductosDisponible(Long codigo_producto) {
        return this.findById(codigo_producto).getCantidad_disponible();
    }

    public void verificarActualizarStock(Producto producto) {
        Producto productoDB = this.findById(producto.getCodigo_producto());
        if (productoDB.getCantidad_disponible()==0) {
            throw new IllegalArgumentException("No hay stock disponible");
        }
        int cantidad_disponible_nueva = productoDB.getCantidad_disponible() - 1;
        productoDB.setCantidad_disponible(cantidad_disponible_nueva);
    }
}
