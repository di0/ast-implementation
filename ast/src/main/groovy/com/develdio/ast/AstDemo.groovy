package com.develdio.ast

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.ast.stmt.Statement
import org.codehaus.groovy.control.CompilationFailedException
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
class AstDemo implements ASTTransformation {
    def alreadyVisited = []

    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        sourceUnit.getAST()?.getClasses().each { classNode ->
            classNode.getAllDeclaredMethods().findAll { MethodNode method ->
                    method.getAnnotations(new ClassNode(Logger))
            }.each { MethodNode method ->
                if (!alreadyVisited.contains(method)) {
                    Statement startMessage = createPrintlnAst("Starting $method.name")
                    Statement endMessage = createPrintlnAst("Ending $method.name")
                    List existingStatements = method.getCode().getStatements()
                    existingStatements.add(0, startMessage)
                    existingStatements.add(endMessage)
                    alreadyVisited << method
                }
    	    }
        }
    }

    private Statement createPrintlnAst(String message) {
        return new ExpressionStatement(
            new MethodCallExpression(new VariableExpression("this"), new ConstantExpression("println"), new ArgumentListExpression(new ConstantExpression(message)))
        )
    }
}
