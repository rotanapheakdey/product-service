package kh.com.bbu.product_service.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
    private String createdDate;
    private int categoryId;
}
