package com.api.idx.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Autowired
public @interface Inject {

    @AliasFor(annotation = Autowired.class, attribute = "required")
    boolean required() default true;
}
