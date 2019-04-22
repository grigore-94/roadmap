package com.pen.roadmap.business.converter;

import com.google.common.base.Converter;
import com.pen.roadmap.business.dto.AuthorDto;
import com.pen.roadmap.repository.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter extends Converter<Author, AuthorDto> {
    @Override
    protected AuthorDto doForward(Author entity) {
        AuthorDto dto = new AuthorDto();

        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setUsername(entity.getUsername());
        dto.setRank(entity.getRank());

        return dto;
    }

    @Override
    protected Author doBackward(AuthorDto dto) {
        Author entity = new Author();

        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setRank(dto.getRank());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}