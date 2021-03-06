package com.pen.roadmap.Validation;

import com.pen.roadmap.business.generic.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntityExistConstraintValidator implements ConstraintValidator<EntityExistConstraint, Long> {
    @Autowired
    private GenericRepository genericRepository;

    private Class className;

    @Override
    public void initialize(EntityExistConstraint constraintAnnotation) {
        className = constraintAnnotation.className();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraint) {
        return genericRepository.find(className, value).isPresent();
    }
}