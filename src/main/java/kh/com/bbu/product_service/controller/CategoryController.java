package kh.com.bbu.product_service.controller;


import kh.com.bbu.product_service.dto.request.CategoryRequest;
import kh.com.bbu.product_service.dto.response.CategoryResponse;
import kh.com.bbu.product_service.entities.CategoryEntity;
import kh.com.bbu.product_service.exceptions.ApiException;
import kh.com.bbu.product_service.exceptions.MessageResponse;
import kh.com.bbu.product_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest request){

        categoryService.createCategory(request);
        return new ResponseEntity<>(null, HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        return new ResponseEntity<>(
                categoryService.getAllCategories(),HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id){
        CategoryResponse categoryResponse= categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(
            @PathVariable int id,
            @RequestBody CategoryRequest request
    ){
        request.setId(id);
        categoryService.update(request);
        return  new ResponseEntity<>("Category Updated!!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id){
        categoryService.delete(id);
        return new ResponseEntity<>("Category Deleteed !!", HttpStatus.OK);
    }
}
