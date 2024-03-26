package com.ingress.autosales.controller;

import com.ingress.autosales.dto.SellerDTO;
import com.ingress.autosales.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/sellers")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerDTO> create(@RequestBody SellerDTO dto) {
        return ResponseEntity.ok(sellerService.create(dto));
    }

}
