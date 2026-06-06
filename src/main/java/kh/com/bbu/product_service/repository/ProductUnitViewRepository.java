package kh.com.bbu.product_service.repository;

//import kh.com.bbu.product_service.entities.ProductUnit;
import kh.com.bbu.product_service.entities.views.ProductUnitView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUnitViewRepository  extends JpaRepository<ProductUnitView, Integer> {

    List<ProductUnitView> findAllByProductId(int productId);
}
