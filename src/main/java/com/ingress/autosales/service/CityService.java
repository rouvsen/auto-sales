package com.ingress.autosales.service;

import com.ingress.autosales.domain.CityEntity;
import com.ingress.autosales.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public CityEntity findById(Integer id) {
        return cityRepository.findById(id).orElseThrow(
                //throw an Exception
        );
    }

}
