package com.ingress.autosales.repository;

import com.ingress.autosales.domain.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
}
