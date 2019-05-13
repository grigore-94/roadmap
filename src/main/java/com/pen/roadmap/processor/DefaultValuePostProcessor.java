package com.pen.roadmap.processor;

import com.pen.roadmap.annotation.DefaultValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class DefaultValuePostProcessor implements BeanPostProcessor
{
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        for (Field field : bean.getClass().getDeclaredFields()) {
            DefaultValue defaultValue = field.getAnnotation(DefaultValue.class);
            if (defaultValue != null) {
                field.setAccessible(true);
                try {
                    field.set(bean, defaultValue.value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}