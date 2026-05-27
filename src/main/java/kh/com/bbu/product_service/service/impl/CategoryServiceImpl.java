package kh.com.bbu.product_service.service.impl;

import kh.com.bbu.product_service.dto.request.CategoryRequest;
import kh.com.bbu.product_service.dto.response.CategoryResponse;
import kh.com.bbu.product_service.entities.CategoryEntity;
import kh.com.bbu.product_service.exceptions.ApiException;
import kh.com.bbu.product_service.mappers.CategoryMapper;
import kh.com.bbu.product_service.repository.CategoryRepository;
import kh.com.bbu.product_service.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void createCategory(CategoryRequest request) {
        CategoryEntity existName = categoryRepository.findByName(request.getName());
        if(existName!=null){
            throw new ApiException("400","Duplicated name");
        }
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(request.getName());
        categoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryResponse getCategoryById(int id) {
        CategoryEntity entity = categoryRepository.findById(id).orElse(null);
        if(entity == null){
            throw new RuntimeException("Category Not Exists!!");
        }
        return categoryMapper.toResponse(entity);
    }

    @Override
    public void update(CategoryRequest request) {
        CategoryEntity existingCategory = categoryRepository.findById(request.getId()).orElseThrow(
                ()-> new RuntimeException("Category Not found!!")
        );

        categoryMapper.updateEntityFromRequest(request,existingCategory);
        categoryRepository.save(existingCategory);
    }



    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
