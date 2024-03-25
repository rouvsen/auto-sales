package com.ingress.autosales.repository;

import com.ingress.autosales.domain.BanTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanTypeRepository extends JpaRepository<BanTypeEntity, Integer> {
}
