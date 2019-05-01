package com.pen.roadmap.repository.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "question")
public class Question extends EntityDescription {

    private String title;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<CommentQuestion> comments = new ArrayList<>();

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();
}
