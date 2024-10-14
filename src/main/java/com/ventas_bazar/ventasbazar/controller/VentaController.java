package com.ventas_bazar.ventasbazar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ventas_bazar.ventasbazar.dto.VentaDTO;
import com.ventas_bazar.ventasbazar.model.Producto;
import com.ventas_bazar.ventasbazar.model.Venta;
import com.ventas_bazar.ventasbazar.service.IVentaService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class VentaController {

    @Autowired
    private IVentaService service;

    @GetMapping("/venta/todos")
    public List<Venta> getAllVenta() {
        return service.findAll();
    }

    @PostMapping("/venta/crear")
    public String crearVenta(@RequestBody Venta venta) {
        service.save(venta);
        return "venta creado";
    }

    @PutMapping("/venta/editar/{id}")
    public String editarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        service.save(venta);
        return "venta modificado";
    }

    @DeleteMapping("/venta/borrar/{id}")
    public String borrarVentaById(@PathVariable Long id) {
        service.deletById(id);
        return "venta eliminado";
    }

    @GetMapping("/venta/traer/{id}")
    public Venta getVentaById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/venta/venta_productos/{codigo_venta}")
    public List<Producto> getProductosDeVenta(@PathVariable Long codigo_venta) {

        return service.findById(codigo_venta).getListaProductos();
    }

    @GetMapping("/ventas/{fecha_venta}")
    public VentaDTO getVentasPorFecha(@RequestParam LocalDate fecha_venta) {
        List<Venta> lista_encontrada = service.findByFechaVenta(fecha_venta);
        Double monto_total = 0.0;
        int cantidad_ventas = 0;
        for (Venta venta : lista_encontrada) {
            monto_total += venta.getTotal();
            cantidad_ventas++;
        }
        return new VentaDTO(monto_total, cantidad_ventas);
    }

    @GetMapping("/ventas/mayor_venta")
    public VentaDTO getVentaConMasMonto() {
        Venta venta_mas_valor_monto = null;
        double monto_mayor = 0.0;
        for (Venta v: service.findAll()) {
            if (monto_mayor < v.getTotal()) {
                venta_mas_valor_monto = v;
            }
        }
        return
            new VentaDTO(venta_mas_valor_monto.getCodigo_venta(),
                        venta_mas_valor_monto.getTotal(), 
                        venta_mas_valor_monto.getListaProductos().size(),
                        venta_mas_valor_monto.getCliente().getNombre(),
                        venta_mas_valor_monto.getCliente().getApellido());
    }



}
