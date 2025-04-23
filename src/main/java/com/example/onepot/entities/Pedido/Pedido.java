package com.example.onepot.entities.Pedido;

import com.example.onepot.dto.PedidoDTO;
import com.example.onepot.entities.Food.Food;
import com.example.onepot.entities.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private LocalDateTime data = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private User cliente;

    @ManyToMany
    @JoinTable(
            name = "pedido_comidas",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<Food> comidas;


    public Pedido(PedidoDTO dados) {
        this.status = dados.status();

    }



}
