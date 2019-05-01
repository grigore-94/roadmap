package com.pen.roadmap.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comment_answer")
public class CommentAnswer extends EntityDescription {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne(targetEntity = CommentAnswer.class)
    @JoinColumn(name = "parent_id")
    private CommentAnswer parent;
}
