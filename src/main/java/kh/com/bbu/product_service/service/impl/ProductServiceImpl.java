package kh.com.bbu.product_service.service.impl;

import kh.com.bbu.product_service.dto.request.ProductRequest;
import kh.com.bbu.product_service.dto.response.ProductResponse;
import kh.com.bbu.product_service.entities.ProductEntity;
import kh.com.bbu.product_service.mappers.ProductMapper;
import kh.com.bbu.product_service.repository.CategoryRepository;
import kh.com.bbu.product_service.repository.ProductRepository;
import kh.com.bbu.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final CategoryRepository categoryRepository;
    @Override
    public List<ProductResponse> getAllProducts(){
//        List<ProductResponse> list = new ArrayList<>();
        List<ProductEntity> productEntityList = productRepository.findAll();
//            productEntityList.forEach((data)->{
//                ProductResponse productResponse =productMapper.toResponse(data);
//                list.add(productResponse);
//            });
        return mapProductToResponseList(productEntityList);
    }

    @Override
    public ProductResponse getProductById(int id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        if (entity == null){
            throw new RuntimeException("Product not found!!");
        }
        return productMapper.toResponse(entity);
    }

    @Override
    public void createProduct(ProductRequest req) {
        var entity =productMapper.toEntity(req);
        entity.setCategory(
                categoryRepository.findById(req.getCategoryId()).orElse(null)
        );

        productRepository.save(entity);
    }

    @Override
    public void update(ProductRequest request) {
        ProductEntity existingProduct = productRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("Product Not Found!!"));

        productMapper.updateEntityFromRequest(request, existingProduct);
        productRepository.save(existingProduct);

    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponse> getAllProductsByCategoryId(int id) {
        return mapProductToResponseList(productRepository.findByCategory_Id(id));
    }

    private List<ProductResponse> mapProductToResponseList(List<ProductEntity> list){

        List<ProductResponse> responseList= new ArrayList<>();
        list.forEach((data)->{
            ProductResponse productResponse =productMapper.toResponse(data);
            responseList.add(productResponse);
        });
        return responseList;
    }

}
