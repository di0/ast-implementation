Purpose
========

The transfomartion AST only will be visited if the annotation "logger" exist on the method.
Eg:
The "Logger" annotation have the follwing configuration: @GroovyASTTransformationClass(['AstDemo']).
So, if the annotation "Logger" is found, transformation AST will be invoked(visited).
This proccess ocurr on compile phase, by adding *compile(project(':ast')* in dependencies build gradle(or any build managment).

In the class HelloAst, we see that the method with Logger annotation will print **Starting method_name** when starting and
**Ending method_name** when it terminate.

See more at **ast** module where it's all located the abstract transformation implementation.

Run
===========

``` bash
gradle clean && \
gradle build && \
gradle run
```

**output:**

```bash
Starting saySomething
Hello Ast(Abstract syntax tree)
Ending saySomething
```
