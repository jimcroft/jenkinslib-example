# jenkinslib-example

Example Jenkins Shared Library example using JenkinsPipelineUnit for testing

## Usage

1. See notes below for setup.
2. Build and run tests

You should see test output like:

```
Testing started at 10:01 ...
10:01:44: Executing external task 'test'...
:compileJava NO-SOURCE
:compileGroovy
:processResources NO-SOURCE
:classes
:compileTestJava NO-SOURCE
:compileTestGroovy
:processTestResources NO-SOURCE
:testClasses
:test
Loading shared library jenkinslib-example with version null
   example1.execute()
      example1.node(groovy.lang.Closure)
         example1.stage(First, groovy.lang.Closure)
            example1.echo(Something)
            example1.sayHello(Traveller)
               sayHello.echo(Hello, Traveller.)
         example1.stage(Middle, groovy.lang.Closure)
            example1.echo(Something done)
         example1.stage(Last, groovy.lang.Closure)
            example1.echo(We're done)
BUILD SUCCESSFUL
Total time: 5.977 secs
10:01:50: External task execution finished 'test'.
```

## Notes

*  Uses a locally built jar of https://github.com/jenkinsci/JenkinsPipelineUnit/pull/75. You'll need to build this 
and update the path in build.gradle
