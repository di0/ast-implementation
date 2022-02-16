package com.develdio

import com.develdio.ast.Logger

/**
 * The transfomation AST only will be visited if the annotation "logger" exist on the method.
 */
public class HelloAst {
    @Logger
    void saySomething() {
        println("Hello Ast(Abstract syntax tree)")
    }

    public static void main(String[] args) {
	    new HelloAst().saySomething()
    }
}


