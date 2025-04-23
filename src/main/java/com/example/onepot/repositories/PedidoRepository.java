package com.example.onepot.repositories;

import com.example.onepot.entities.Pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
