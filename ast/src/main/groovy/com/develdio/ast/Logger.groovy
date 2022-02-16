package com.develdio.ast

import org.codehaus.groovy.transform.GroovyASTTransformationClass

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.CLASS)
@Target([ElementType.METHOD])
@GroovyASTTransformationClass(['com.develdio.ast.AstDemo'])
public @interface Logger {
    Class value
}
