package kh.com.bbu.product_service.service.impl;

import kh.com.bbu.product_service.dto.request.ProductRequest;
import kh.com.bbu.product_service.dto.response.ProductResponse;
import kh.com.bbu.product_service.dto.response.ProductUnitResponse;
import kh.com.bbu.product_service.entities.ProductEntity;
import kh.com.bbu.product_service.entities.ProductUnit;
import kh.com.bbu.product_service.exceptions.ApiException;
import kh.com.bbu.product_service.mappers.ProductMapper;
import kh.com.bbu.product_service.mappers.ProductUnitMapper;
import kh.com.bbu.product_service.repository.CategoryRepository;
import kh.com.bbu.product_service.repository.ProductRepository;
import kh.com.bbu.product_service.repository.ProductUnitRepository;
import kh.com.bbu.product_service.repository.ProductUnitViewRepository;
import kh.com.bbu.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final CategoryRepository categoryRepository;
    private final ProductUnitViewRepository productUnitViewRepository;
//    private final ProductUnitMapper productUnitMapper;
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
            throw new ApiException("400","Product not found!!");
        }

        var response = productMapper.toResponse(entity);
        response.setProductUnitList(getAllProductUnitResponse(response.getId()));
        return response;
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

    @Override
    public ProductResponse getProductByBarcode(String barcode) {
        if(Strings.isBlank(barcode)){
            throw  new ApiException("400","Barcode is required");
        }
        var product = productRepository.findByBarcode(barcode);
        if(Objects.isNull(product)){
            throw new ApiException("400", "Product Not Found");
        }

        var response = productMapper.toResponse(product);
        response.setProductUnitList(getAllProductUnitResponse(response.getId()));
        return response;
    }

    private List<ProductResponse> mapProductToResponseList(List<ProductEntity> list){

        List<ProductResponse> responseList= new ArrayList<>();
        list.forEach((data)->{
            ProductResponse productResponse =productMapper.toResponse(data);
            responseList.add(productResponse);
        });
        return responseList;
    }

    private List<ProductUnitResponse> getAllProductUnitResponse(int productId){
        List<ProductUnitResponse> productUnitResponseList = new ArrayList<>() ;
        productUnitViewRepository.findAllByProductId(productId).forEach((data)->{
            var productUnitResponse = ProductUnitMapper.toResponse(data);
            productUnitResponseList.add(productUnitResponse);
        });
        return productUnitResponseList;
    }
}
