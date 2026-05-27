package kh.com.bbu.product_service.service;

import kh.com.bbu.product_service.dto.request.CategoryRequest;
import kh.com.bbu.product_service.dto.response.CategoryResponse;
import kh.com.bbu.product_service.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {

    void createCategory(CategoryRequest request);

    List<CategoryEntity> getAllCategories();
    CategoryResponse getCategoryById(int id);
    void update(CategoryRequest request);

    void delete(int id);
}
