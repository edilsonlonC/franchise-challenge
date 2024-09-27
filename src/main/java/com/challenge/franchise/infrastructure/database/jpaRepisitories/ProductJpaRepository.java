package com.challenge.franchise.infrastructure.database.jpaRepisitories;

import com.challenge.franchise.infrastructure.database.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> { }
