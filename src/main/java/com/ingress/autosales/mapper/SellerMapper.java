package com.ingress.autosales.mapper;

import com.ingress.autosales.domain.SellerEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import com.ingress.autosales.dto.SellerDTO;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface SellerMapper {

    SellerDTO sellerToSellerDTO(SellerEntity seller);

    SellerEntity sellerDTOToSeller(SellerDTO sellerDTO);
}
