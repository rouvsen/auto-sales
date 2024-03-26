package com.ingress.autosales.repository;

import com.ingress.autosales.domain.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface AutoRepository extends JpaRepository<AutoEntity, Integer>, JpaSpecificationExecutor<AutoEntity> {

    Optional<AutoEntity> findByPin(UUID pin);

}
