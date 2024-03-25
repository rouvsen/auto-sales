package com.ingress.autosales.configs;

import com.ingress.autosales.mapper.SellerMapper;
import com.ingress.autosales.mapper.SellerMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {

    @Bean
    public SellerMapper sellerMapper() {
        return new SellerMapperImpl();
    }

}
