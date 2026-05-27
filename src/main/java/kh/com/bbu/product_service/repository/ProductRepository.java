package kh.com.bbu.product_service.repository;


import kh.com.bbu.product_service.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategory_Id(int categoryId);
    List<ProductEntity> findByCategory_IdOrderByIdDesc(int categoryId);

}
