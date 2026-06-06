package kh.com.bbu.product_service.controller;

import kh.com.bbu.product_service.dto.request.ProductRequest;
import kh.com.bbu.product_service.dto.response.ProductResponse;
import kh.com.bbu.product_service.exceptions.MessageResponse;
import kh.com.bbu.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<MessageResponse<List<ProductResponse>>> getAllProducts(){
        return new ResponseEntity<>(
                new MessageResponse<>(
                        productService.getAllProducts(),
                        true,
                        "GetDataSuccess!!",
                        "200"
                ),HttpStatus.OK
        );



    }
    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getProductById(@PathVariable int id){
        ProductResponse productResponse = productService.getProductById(id);

        return new ResponseEntity<>(new MessageResponse(
                productResponse,
                true,
                "Get Product By Id success!!",
                "200"), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> createProduct(
      @RequestBody ProductRequest request
    ){
        productService.createProduct(request);
        return new ResponseEntity<>("Product created successfully!", HttpStatus.CREATED);
    };

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(
            @PathVariable int id,
        @RequestBody ProductRequest request
    ){
        request.setId(id);
        productService.update(request);
        return new ResponseEntity<>("Product updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(
            @PathVariable int id
    ){
        productService.delete(id);
        return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getAllProductsByCategoryId(
            @PathVariable("id") int id
    ){
        return new ResponseEntity<>(
                productService.getAllProductsByCategoryId(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<MessageResponse> getProductById(@PathVariable String barcode){
        ProductResponse productResponse = productService.getProductByBarcode(barcode);

        return new ResponseEntity<>(new MessageResponse(
                productResponse,
                true,
                "Get Product By barcode success!!",
                "200"), HttpStatus.OK
        );
    }
}
