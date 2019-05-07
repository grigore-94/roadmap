package com.pen.roadmap.business.converter;

import com.google.common.base.Converter;
import com.pen.roadmap.business.dto.QuestionDto;
import com.pen.roadmap.repository.UserRepository;
import com.pen.roadmap.repository.entity.User;
import com.pen.roadmap.repository.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class QuestionConverter extends Converter<Question, QuestionDto> {
    private final DescriptionConverter descriptionConverter;
    private final UserRepository authorRepository;

    @Override
    protected QuestionDto doForward(Question entity) {
        QuestionDto dto = new QuestionDto();

        dto = (QuestionDto) descriptionConverter.doBackward(entity, dto);
        dto.setTitle(entity.getTitle());
        dto.setUserId(entity.getUser().getId());

        return dto;
    }

    @Override
    protected Question doBackward(QuestionDto dto) {
        Question entity = new Question();

        entity = (Question) descriptionConverter.doForward(entity, dto);
        entity.setTitle(dto.getTitle());

        Optional<User> author = authorRepository.findById(dto.getUserId());
        entity.setUser(author.get());

        return entity;
    }
}
