package com.ingress.autosales.service;

import com.ingress.autosales.domain.AutoDetailsEntity;
import com.ingress.autosales.repository.AutoDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutoDetailsService {

    private final AutoDetailsRepository autoDetailsRepository;

    public AutoDetailsEntity create(AutoDetailsEntity entity) {
        return autoDetailsRepository.save(entity);
    }

}
