package com.ingress.autosales.repository;

import com.ingress.autosales.domain.AutoDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoDetailsRepository extends JpaRepository<AutoDetailsEntity, Integer> {
}
