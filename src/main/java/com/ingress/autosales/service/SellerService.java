package com.ingress.autosales.service;

import com.ingress.autosales.domain.SellerEntity;
import com.ingress.autosales.dto.SellerDTO;
import com.ingress.autosales.mapper.SellerMapper;
import com.ingress.autosales.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;
    private final SellerMapper sellerMapper;

    @Transactional
    public SellerDTO create(SellerDTO dto) {
        if (sellerRepository.findByUsername(dto.username()).isPresent()) {
            //throw an Exception
        }
        SellerEntity entity = sellerRepository.save(sellerMapper.sellerDTOToSeller(dto));
        return sellerMapper.sellerToSellerDTO(entity);
    }

    public SellerEntity findById(Integer sellerId) {
        return sellerRepository.findById(sellerId).orElseThrow(
                //throw an Exception
        );
    }

    //TODO: SQLIntegrityConstraintViolationException write Global Ex Handling
}
