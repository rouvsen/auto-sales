package com.ingress.autosales.controller;

import com.ingress.autosales.criteria.SearchCriteria;
import com.ingress.autosales.domain.AutoEntity;
import com.ingress.autosales.dto.AutoDTO;
import com.ingress.autosales.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/autos")
@RequiredArgsConstructor
public class AutoController {

    private final AutoService autoService;

    @PostMapping(value = "/{sellerId}")
    public ResponseEntity<AutoEntity> create(@RequestBody AutoDTO entity, @PathVariable Integer sellerId) {
        return ResponseEntity.ok(autoService.create(entity, sellerId));
    }

    @GetMapping
    public ResponseEntity<List<AutoEntity>> getAll() {
        return ResponseEntity.ok(autoService.getAll());
    }

    // GET /autos/search?search=brand:BMW&search=year>2015&search=price<30000&page=0&size=10
    @GetMapping("/search")
    public Page<AutoEntity> searchAutos(
            @RequestParam List<String> search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<SearchCriteria> criteriaList = autoService.parseSearchCriteria(search);
        Pageable pageable = PageRequest.of(page, size);
        return autoService.searchAutos(criteriaList, pageable);
    }


    @DeleteMapping(value = "/{sellerId}/auto/{pin}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer sellerId, @PathVariable String pin) {
        autoService.delete(sellerId, pin);
    }

}
