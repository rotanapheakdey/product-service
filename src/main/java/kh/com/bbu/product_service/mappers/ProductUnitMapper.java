package kh.com.bbu.product_service.mappers;

import kh.com.bbu.product_service.dto.response.ProductUnitResponse;
import kh.com.bbu.product_service.entities.views.ProductUnitView;

public class ProductUnitMapper {
    public static ProductUnitResponse toResponse(ProductUnitView data){
        return ProductUnitResponse.builder()
                .id(data.getId())
                .unitTypeId(data.getUnitTypeId())
                .cost(data.getCost())
                .price(data.getPrice())
                .productId(data.getProductId())
                .qty(data.getQty())
                .productName(data.getProductName())
                .unitTypeName(data.getUnitTypeName())
                .build();
    }
}
