package com.spring.boot.repo;

import com.spring.boot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

     @Query("SELECT p FROM Product p WHERE LOWER(p.name) = LOWER(:name)")
     Product findByNameIgnoreCase(@Param("name") String name);

     Optional<Product> findById(Long id);


}
