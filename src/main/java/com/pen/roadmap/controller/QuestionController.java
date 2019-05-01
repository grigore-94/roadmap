package com.pen.roadmap.controller;

import com.pen.roadmap.business.AuthorBusiness;
import com.pen.roadmap.business.QuestionBusiness;
import com.pen.roadmap.business.dto.AuthorDto;
import com.pen.roadmap.business.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionBusiness business;

    @GetMapping
    public List<QuestionDto> retrieve(Pageable pageable) {
        return business.retrieve(pageable);
    }

    @PostMapping
    @Valid
    public QuestionDto create(@RequestBody @Valid QuestionDto dto) {
        return business.create(dto).get();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDto> get(@PathVariable Long id) {
        Optional<QuestionDto> question = business.get(id);

        return new ResponseEntity<>(question.orElse(null), question.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/rank/up/{id}")
    public  ResponseEntity<QuestionDto> rankUp(@PathVariable Long id) {
        Optional<QuestionDto> question = business.addToRank(id, 1);

        return new ResponseEntity<>(question.orElse(null), question.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/rank/down/{id}")
    public  ResponseEntity<QuestionDto> rankDown(@PathVariable Long id) {
        Optional<QuestionDto> question = business.addToRank(id, -1);

        return new ResponseEntity<>(question.orElse(null), question.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
