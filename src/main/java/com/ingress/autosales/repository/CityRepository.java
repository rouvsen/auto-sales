package com.ingress.autosales.repository;

import com.ingress.autosales.domain.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {
}
