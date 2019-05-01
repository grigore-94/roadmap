package com.pen.roadmap.controller;

import com.pen.roadmap.business.AuthorBusiness;
import com.pen.roadmap.business.dto.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorBusiness business;

    @GetMapping
    public List<AuthorDto> retrieve(Pageable pageable) {
        return business.retrieve(pageable);
    }

    @PostMapping
    @Valid
    public AuthorDto create(@RequestBody @Valid AuthorDto dto) {
        return business.create(dto).get();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> get(@PathVariable Long id) {
        Optional<AuthorDto> author = business.get(id);

        return new ResponseEntity<>(author.orElse(null), author.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
