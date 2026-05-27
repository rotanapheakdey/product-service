package kh.com.bbu.product_service.service;

import kh.com.bbu.product_service.dto.request.ProductRequest;
import kh.com.bbu.product_service.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse>getAllProducts();
    ProductResponse getProductById(int id);
    void createProduct(ProductRequest req);

    void update(ProductRequest request);

//    void delete(int id, ProductRequest request);

    void delete(int id);
    List<ProductResponse> getAllProductsByCategoryId(int id);
}
