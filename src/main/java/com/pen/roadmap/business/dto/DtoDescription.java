package com.pen.roadmap.business.dto;

import com.pen.roadmap.repository.entity.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class DtoDescription {
    private long id;
    private String content;
    private int rank;
    private Date createdAt;
}
