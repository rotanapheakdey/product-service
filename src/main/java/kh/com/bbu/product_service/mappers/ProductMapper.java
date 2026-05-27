package kh.com.bbu.product_service.mappers;

import kh.com.bbu.product_service.dto.request.ProductRequest;
import kh.com.bbu.product_service.dto.response.ProductResponse;
import kh.com.bbu.product_service.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductMapper {
    public ProductEntity toEntity(ProductRequest request){
        return ProductEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .build();
    }

    public ProductResponse toResponse(ProductEntity request){
        return ProductResponse.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .createdDate("")
                .category(Objects.isNull(request.getCategory())?null: request.getCategory())

                .build();
    }
    public void updateEntityFromRequest(ProductRequest request, ProductEntity entity){

        entity.setTitle((request.getTitle()));
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setDiscount(request.getDiscount());

    }

}
