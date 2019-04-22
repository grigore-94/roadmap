package com.pen.roadmap.repository;

import com.pen.roadmap.repository.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
