package kh.com.bbu.product_service.repository;

import kh.com.bbu.product_service.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository  extends JpaRepository<CategoryEntity, Integer> {

    CategoryEntity findByName(String name);


}
