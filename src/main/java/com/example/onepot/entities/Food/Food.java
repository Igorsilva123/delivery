package com.example.onepot.entities.Food;
import com.example.onepot.dto.FoodPutDTO;
import com.example.onepot.dto.FoodRequestDTO;
import com.example.onepot.entities.Pedido.Pedido;
import com.example.onepot.entities.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "foods")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String image;
    private Integer price;


    @ManyToMany(mappedBy = "comidas")
    private List<Pedido> pedidos;


    public Food (FoodRequestDTO data){
        this.title = data.title();
        this.description = data.description();
        this.image = data.image();
        this.price = data.price();

    }
    public void atualizar(FoodPutDTO data){
        if(data.title() != null){
            this.title = data.title();
        }
        if(data.price() != null){
            this.price = data.price();
        }
        if(data.description() != null){
            this.description = data.description();
        }
        if(data.image() != null){
            this.image = data.image();
        }
    }


}
