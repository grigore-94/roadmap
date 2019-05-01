package com.pen.roadmap.business.converter;

import com.pen.roadmap.business.dto.DtoDescription;
import com.pen.roadmap.repository.entity.EntityDescription;
import org.springframework.stereotype.Component;

@Component
public class DescriptionConverter {

    protected EntityDescription doForward(EntityDescription entity, DtoDescription dto) {

        entity.setId(dto.getId());
        entity.setContent(dto.getContent());
        entity.setRank(dto.getRank());

        return entity;
    }

    protected DtoDescription doBackward(EntityDescription entity, DtoDescription dto) {

        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        dto.setRank(entity.getRank());
        dto.setCreatedAt(entity.getCreatedAt());

        return dto;
    }
}
