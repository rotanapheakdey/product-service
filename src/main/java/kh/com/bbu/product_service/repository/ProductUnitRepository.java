package kh.com.bbu.product_service.repository;

import kh.com.bbu.product_service.entities.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUnitRepository extends JpaRepository<ProductUnit,Integer> {
    List<ProductUnit> findAllByProductId(int productId);
}
