package com.ingress.autosales.controller;

import com.ingress.autosales.domain.AutoEntity;
import com.ingress.autosales.dto.AutoDTO;
import com.ingress.autosales.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/autos")
@RequiredArgsConstructor
public class AutoController {

    private final AutoService autoService;

    @PostMapping(value = "/{sellerId}")
    public ResponseEntity<AutoEntity> create(@RequestBody AutoDTO entity, @PathVariable Integer sellerId) {
        return ResponseEntity.ok(autoService.create(entity, sellerId));
    }

    @DeleteMapping(value = "/{sellerId}/auto/{pin}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer sellerId, @PathVariable String pin) {
        autoService.delete(sellerId, pin);
    }

}
