 mvn compile (just compile)
 mvn test (compile and run unit tests)
 mvn package (compile, run unit tests, and build the distributable package)
 mvn install (all of the above, and install distributable package into local repository.
     Install is very useful if you need to build other packages which depend on changes
     to this package)
 mvn deploy (all of the above, and install package into remote (aka public) repository
     for sharing with other developers)