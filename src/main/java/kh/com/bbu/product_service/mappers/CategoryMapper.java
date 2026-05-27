package kh.com.bbu.product_service.mappers;


import kh.com.bbu.product_service.dto.request.CategoryRequest;
import kh.com.bbu.product_service.dto.response.CategoryResponse;
import kh.com.bbu.product_service.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponse toResponse(CategoryEntity request){
        return CategoryResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }

    public void updateEntityFromRequest(CategoryRequest request, CategoryEntity entity){
        entity.setName(request.getName());
    }
}
