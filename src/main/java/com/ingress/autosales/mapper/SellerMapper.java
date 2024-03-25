package com.ingress.autosales.mapper;

import com.ingress.autosales.domain.SellerEntity;
import org.mapstruct.Mapper;
import com.ingress.autosales.dto.SellerDTO;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    SellerDTO sellerToSellerDTO(SellerEntity seller);

    SellerEntity sellerDTOToSeller(SellerDTO sellerDTO);
}
