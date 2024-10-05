package com.ventas_bazar.ventasbazar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas_bazar.ventasbazar.model.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long>{

    
} 
