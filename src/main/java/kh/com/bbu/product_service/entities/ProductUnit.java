package kh.com.bbu.product_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_units")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double qty;
    private double price;
    private double cost;
    private int unitTypeId;
    private int productId;

}
