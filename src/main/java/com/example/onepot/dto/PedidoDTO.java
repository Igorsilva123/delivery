package com.example.onepot.dto;

import com.example.onepot.entities.Pedido.StatusPedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PedidoDTO(@NotNull Long user_id, @NotNull List<Long> food_id, StatusPedido status) {
}



