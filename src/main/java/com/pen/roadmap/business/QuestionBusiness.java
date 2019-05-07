package com.pen.roadmap.business;

import com.pen.roadmap.business.converter.QuestionConverter;
import com.pen.roadmap.business.dto.QuestionDto;
import com.pen.roadmap.repository.QuestionRepository;
import com.pen.roadmap.repository.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionBusiness {
    private final QuestionConverter converter;
    private final QuestionRepository repository;

    public List<QuestionDto> retrieve(Pageable pageable) {
        return repository
                .findAll(pageable)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public Optional<QuestionDto> create(QuestionDto dto) {
        return Optional.of(repository.save(converter.reverse().convert(dto))).map(converter::convert);
    }

    public Optional<QuestionDto> get(long id) {
        return Optional.ofNullable(converter.convert(repository.findById(id).orElse(null)));
    }

    public Optional<QuestionDto> addToRank(long id, int toAdd) {

        Optional<Question> question = repository.findById(id);
        question.ifPresent(q -> {q.setRank(q.getRank() + toAdd); repository.save(q);});


        return Optional.ofNullable(converter.convert(question.orElse(null)));
    }
}
