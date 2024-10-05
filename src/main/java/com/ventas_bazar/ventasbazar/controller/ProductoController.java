package com.ventas_bazar.ventasbazar.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ventas_bazar.ventasbazar.model.Producto;
import com.ventas_bazar.ventasbazar.service.IProductoService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductoController {
    @Autowired
    IProductoService service;

    @GetMapping("/producto/todos")
    public List<Producto> getAllProductos() {
        return service.findAll();
    }

    @PostMapping("/producto/crear")
    public String crearProducto(@RequestBody Producto producto) {
        service.save(producto);
        return "producto creado";
    }

    @PutMapping("/producto/editar/{id}")
    public String editarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        service.save(producto);
        return "producto modificado";
    }

    @DeleteMapping("/producto/borrar/{id}")
    public String borrarProductoById(@PathVariable Long id) {
        service.deletById(id);
        return "producto eliminado";
    }
    @GetMapping("/producto/traer/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/producto/falta_stock")
    public List<Producto> getFaltaStock() {
        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : service.findAll()) {
            if(producto.getCantidad_disponible()<= 5){
                resultado.add(producto);
            }
        }
        return resultado;
    }

    

}
