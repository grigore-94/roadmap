package com.pen.roadmap.business.converter;

import com.google.common.base.Converter;
import com.pen.roadmap.business.dto.UserDto;
import com.pen.roadmap.repository.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends Converter<User, UserDto> {
    @Override
    protected UserDto doForward(User entity) {
        UserDto dto = new UserDto();

        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setUsername(entity.getUsername());
        dto.setRank(entity.getRank());

        return dto;
    }

    @Override
    protected User doBackward(UserDto dto) {
        User entity = new User();

        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setRank(dto.getRank());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}