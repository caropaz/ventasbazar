package com.ventas_bazar.ventasbazar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas_bazar.ventasbazar.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long>{

    
}
