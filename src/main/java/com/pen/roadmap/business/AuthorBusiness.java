package com.pen.roadmap.business;

import com.pen.roadmap.business.converter.AuthorConverter;
import com.pen.roadmap.business.dto.AuthorDto;
import com.pen.roadmap.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorBusiness {
    private final AuthorConverter converter;
    private final AuthorRepository repository;

    public List<AuthorDto> retrieve() {
        return repository
                .findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public Optional<AuthorDto> create(AuthorDto dto) {
        return Optional.of(repository.save(converter.reverse().convert(dto))).map(converter::convert);
    }
}
