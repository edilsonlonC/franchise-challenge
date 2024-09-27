package com.challenge.franchise.infrastructure.database.jpaRepisitories;

import com.challenge.franchise.infrastructure.database.entities.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchJpaRepository extends JpaRepository<BranchEntity, Long> { }
