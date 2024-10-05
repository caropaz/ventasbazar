package com.ventas_bazar.ventasbazar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas_bazar.ventasbazar.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long>{
    
}
