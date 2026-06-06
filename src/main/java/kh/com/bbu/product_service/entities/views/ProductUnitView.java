package kh.com.bbu.product_service.entities.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Table(name = "product_units_view")
@Entity
@Getter
@Setter
@Immutable
public class ProductUnitView {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "qty")
    private double qty;

    @Column(name = "price")
    private double price;

    @Column(name = "cost")
    private double cost;
    @Column(name = "unit_type_id")
    private int unitTypeId;
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_type_name")
    private String unitTypeName;
}
