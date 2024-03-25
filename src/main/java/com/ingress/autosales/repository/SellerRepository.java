package com.ingress.autosales.repository;

import com.ingress.autosales.domain.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {
    Optional<SellerEntity> findByUsername(String username);
}
