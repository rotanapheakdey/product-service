package kh.com.bbu.product_service.dto.response;

import kh.com.bbu.product_service.entities.CategoryEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
    private String createdDate;
    private CategoryEntity category;
}
