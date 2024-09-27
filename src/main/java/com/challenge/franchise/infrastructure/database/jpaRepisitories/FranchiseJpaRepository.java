package com.challenge.franchise.infrastructure.database.jpaRepisitories;

import com.challenge.franchise.infrastructure.database.entities.FranchiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FranchiseJpaRepository extends JpaRepository<FranchiseEntity, Long> {
}
