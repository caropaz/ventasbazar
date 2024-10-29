package com.ventas_bazar.ventasbazar.controller;

import com.ventas_bazar.ventasbazar.dto.Venta_PorFecha_DTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ventas_bazar.ventasbazar.dto.Mayoria_Venta_ProductoDTO;
import com.ventas_bazar.ventasbazar.model.Producto;
import com.ventas_bazar.ventasbazar.model.Venta;
import com.ventas_bazar.ventasbazar.service.IVentaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public ResponseEntity<?> crearVenta(@Valid @RequestBody Venta venta) {

        try {
            service.save(venta);
            return ResponseEntity.ok("venta creado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/venta/editar/{id}")
    public String editarVenta(@Valid @PathVariable Long id, @RequestBody Venta venta) {
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

    @GetMapping("/venta/fecha/{fecha_venta}")
    public Venta_PorFecha_DTO getVentasPorFecha(@PathVariable String fecha_venta) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate fecha_parse = LocalDate.parse(fecha_venta, formatter);
        List<Venta> lista_encontrada = service.findByFechaVenta(fecha_parse);
        Double monto_total = 0.0;
        int cantidad_ventas = 0;
        for (Venta venta : lista_encontrada) {
            monto_total += venta.getTotal();
            cantidad_ventas++;
        }


        return new Venta_PorFecha_DTO(monto_total, cantidad_ventas) ;
    }

    @GetMapping("/venta/mayor_venta")
    public Mayoria_Venta_ProductoDTO getVentaConMasMonto() {
        Venta venta_mas_valor_monto = null;
        double monto_mayor = 0.0;
        for (Venta v: service.findAll()) {
            if (monto_mayor < v.getTotal()) {
                venta_mas_valor_monto = v;
            }
        }
        return
            new Mayoria_Venta_ProductoDTO(venta_mas_valor_monto.getCodigo_venta(),
                        venta_mas_valor_monto.getTotal(), 
                        venta_mas_valor_monto.getListaProductos().size(),
                        venta_mas_valor_monto.getCliente().getNombre(),
                        venta_mas_valor_monto.getCliente().getApellido());
    }



}
