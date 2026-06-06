package kh.com.bbu.product_service.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    private boolean deleted;
    @ManyToOne
    private CategoryEntity category;
    private String barcode;
}
