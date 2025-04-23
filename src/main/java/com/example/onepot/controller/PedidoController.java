package com.example.onepot.controller;

import com.example.onepot.dto.PedidoDTO;
import com.example.onepot.entities.Food.Food;
import com.example.onepot.entities.Pedido.Pedido;
import com.example.onepot.entities.User.User;
import com.example.onepot.repositories.FoodRepository;
import com.example.onepot.repositories.PedidoRepository;
import com.example.onepot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Transactional
    @PostMapping("/fazerpedido")
    public ResponseEntity fazerPedido(@RequestBody PedidoDTO dados) {
        List<Food> comidas = foodRepository.findAllById(dados.food_id());
        User cliente = userRepository.findById(dados.user_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setStatus(dados.status());
        pedido.setCliente(cliente);
        pedido.setData(LocalDateTime.now());
        pedido.setComidas(comidas);


        Pedido salvo = pedidoRepository.save(pedido);
        return ResponseEntity.ok(salvo);

    }

}

