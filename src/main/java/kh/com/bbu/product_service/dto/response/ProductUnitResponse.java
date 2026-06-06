package kh.com.bbu.product_service.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductUnitResponse{
    private int id;
    private double qty;
    private double price;
    private double cost;
    private int unitTypeId;
    private int productId;
    private String productName;
    private String unitTypeName;
}
