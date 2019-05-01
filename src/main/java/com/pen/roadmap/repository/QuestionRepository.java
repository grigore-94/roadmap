package com.pen.roadmap.repository;

import com.pen.roadmap.repository.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}

