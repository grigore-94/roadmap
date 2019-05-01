package com.pen.roadmap.business.converter;

import com.google.common.base.Converter;
import com.pen.roadmap.business.dto.QuestionDto;
import com.pen.roadmap.repository.AuthorRepository;
import com.pen.roadmap.repository.entity.Author;
import com.pen.roadmap.repository.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class QuestionConverter extends Converter<Question, QuestionDto> {
    private final DescriptionConverter descriptionConverter;
    private final AuthorRepository authorRepository;

    @Override
    protected QuestionDto doForward(Question entity) {
        QuestionDto dto = new QuestionDto();

        dto = (QuestionDto) descriptionConverter.doBackward(entity, dto);
        dto.setTitle(entity.getTitle());
        dto.setAuthorId(entity.getAuthor().getId());

        return dto;
    }

    @Override
    protected Question doBackward(QuestionDto dto) {
        Question entity = new Question();

        entity = (Question) descriptionConverter.doForward(entity, dto);
        entity.setTitle(dto.getTitle());

        Optional<Author> author = authorRepository.findById(dto.getAuthorId());
        entity.setAuthor(author.get());

        return entity;
    }
}
