package com.ventas_bazar.ventasbazar.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Venta_PorFecha_DTO {
    private Double monto_total_listado;
    private int cantidad_ventas;

    public Venta_PorFecha_DTO() {

    }

    public Venta_PorFecha_DTO(Double monto_total_listado, int cantidad_ventas) {
        this.monto_total_listado =monto_total_listado;
        this.cantidad_ventas = cantidad_ventas;
    }
}
