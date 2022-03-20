Purpose
========

The transfomartion AST only will be visited if the annotation "logger" exist on the method.
Eg:

The "Logger" annotation has the following configuration:

```bash
@GroovyASTTransformationClass(['AstDemo'])
```

So, if the annotation "Logger" is found, the transformation AST will be invoking(visited) the target unit.
This proccess occurs on compile phase, when adding *compile(project(':ast')* in dependencies build gradle(or any build managment).

In the class HelloAst, we see that the method with Logger annotation will print out **Starting method method_name** when starting and
**Ending method method_name** when it terminates.

See more in **ast** module(directory), where are all the abstract transformation implementations.

Run
===========

``` bash
gradle clean && \
gradle build && \
gradle run
```
**output:**

```bash
Starting method saySomething
Hello Ast(Abstract syntax tree)
Ending method saySomething
```
