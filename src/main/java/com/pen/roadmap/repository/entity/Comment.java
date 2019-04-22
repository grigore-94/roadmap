package com.pen.roadmap.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public abstract class Comment extends EntityDescription {
    @ManyToOne(targetEntity = Comment.class)
    @JoinColumn(name = "parent_id")
    private Comment parent;
}
