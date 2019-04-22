package com.pen.roadmap.controller;

import com.pen.roadmap.business.AuthorBusiness;
import com.pen.roadmap.business.dto.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorBusiness business;

    @GetMapping
    public List<AuthorDto> retrieve() {
        return business.retrieve();
    }

    @PostMapping
    @Valid
    public AuthorDto create(@RequestBody @Valid AuthorDto dto) {
        return business.create(dto).get();
    }
}
