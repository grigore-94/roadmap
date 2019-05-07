package com.pen.roadmap.business.dto;

import com.pen.roadmap.Validation.EntityExistConstraint;
import com.pen.roadmap.repository.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class DtoDescription {
    private long id;
    private String content;
    private int rank;
    private Instant createdAt;

    @EntityExistConstraint(className = User.class)
    private Long userId;
}
