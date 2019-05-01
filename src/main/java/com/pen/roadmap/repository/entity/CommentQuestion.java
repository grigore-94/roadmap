package com.pen.roadmap.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comment_question")
public class CommentQuestion extends EntityDescription {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(targetEntity = CommentQuestion.class)
    @JoinColumn(name = "parent_id")
    private CommentQuestion parent;
}
