package com.ingress.autosales.service;

import com.ingress.autosales.domain.BanTypeEntity;
import com.ingress.autosales.repository.BanTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BanTypeService {

    private final BanTypeRepository banTypeRepository;

    public BanTypeEntity findById(Integer id) {
        return banTypeRepository.findById(id).orElseThrow(
                //throw an Exception
        );
    }
}
