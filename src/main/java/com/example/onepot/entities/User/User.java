package com.example.onepot.entities.User;

import com.example.onepot.dto.RegisterRequestDTO;
import com.example.onepot.entities.Food.Food;
import com.example.onepot.entities.Pedido.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String secondname;
    private String email;
    private String password;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Role role;



    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;


}
