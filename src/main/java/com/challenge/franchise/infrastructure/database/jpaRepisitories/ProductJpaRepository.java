package com.challenge.franchise.infrastructure.database.jpaRepisitories;

import com.challenge.franchise.infrastructure.database.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {


    @Query(value = "SELECT p FROM ProductEntity p " +
            "JOIN p.branch b " +
            "JOIN b.franchise f " +
            "WHERE f.id = :franchiseId " +
            "AND p.quantity = (SELECT MAX(p2.quantity) FROM ProductEntity p2 WHERE p2.branch.id = b.id) " +
            "ORDER BY b.name")
    List<ProductEntity> findTopProductsByQuantity(Long franchiseId);
}
