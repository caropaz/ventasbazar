package com.ventas_bazar.ventasbazar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas_bazar.ventasbazar.model.Venta;
import com.ventas_bazar.ventasbazar.repository.IVentaRepository;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;
    @Override
    public void save(Venta v) {
        ventaRepository.save(v);
    }

    @Override
    public void deletById(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public void edit(Venta v) {
        ventaRepository.save(v);

    }

    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta findById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Venta> findByFechaVenta(LocalDate fecha) {
        List<Venta> lista_devolver =  new ArrayList<>();
        for (Venta venta : this.findAll()) {
            if (venta.getFecha_venta() == fecha) {
                lista_devolver.add(venta);
            }
        }
        return  lista_devolver;
    }

    
    
}
