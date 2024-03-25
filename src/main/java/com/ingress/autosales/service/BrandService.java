package com.ingress.autosales.service;

import com.ingress.autosales.domain.BrandEntity;
import com.ingress.autosales.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandEntity findById(Integer id) {
        return brandRepository.findById(id).orElseThrow(
                //throw an Exception
        );
    }
}
