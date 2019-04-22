package com.pen.roadmap.business.generic;

import com.pen.roadmap.repository.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@Service
public class GenericRepository {

    Repositories repositories;

    @Autowired
    public GenericRepository(WebApplicationContext appContext) {
        repositories = new Repositories(appContext);
    }

    public JpaRepository getRepository(Class entityClass) {
        return (JpaRepository) repositories.getRepositoryFor(entityClass).get();
    }

    public Optional<Object> find(Class entityClass, Long id) {
        return getRepository(entityClass).findById(id);
    }
}
