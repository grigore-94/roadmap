package com.pen.roadmap.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question extends EntityDescription {

    private String title;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<CommentQuestion> comments = new ArrayList<>();

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();
}
