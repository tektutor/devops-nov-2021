### Compiling Maven application code
```
mvn compile
```

### Cleaning target folder that has all binaries( class, jar, war, ear, etc )
```
mvn clean
```

### Creating a package ( jar, war, ear, etc )
```
mvn package
```

### Finding the Maven Plugin goals and configuration
```
mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin:3.1 -Ddetail
```

### Maven Life Cycle
- Maven supports 3 built-in life cycle
   1. default ( 23 Phases )
   2. clean ( 3 Phases )
   3. site ( 4 Phases )
- Maven Life is a chain of commands invoked one after other from top to bottom in the pre-defined order
- Each Lifecycle has one or more Phases
- Each Phase in the LifeCycle can be configured to invoke one or more Plugin goals
- Each Plugin has one or more Goals
- Each Goal does one task

### Finding the default lifecycle phases
```
mvn help:describe -Dcmd=compile
```

### Finding the clean lifecycle phases
```
mvn help:describe -Dcmd=clean
```

### Finding the site lifecycle phases
```
mvn help:describe -Dcmd=site
```

### Compiling C++ application using Maven
```
cd ~/devops-nov-2021
git pull
git checkout master
cd Day1/CppHello
mvn compile
```

### Cleaning the C++ binaries using Maven
```
cd ~/devops-nov-2021
git pull
git checkout master
cd Day1/CppHello
mvn clean
```

### Setting up JFrog Artifactory Maven Repository (RPS Cloud Machine - Terminal)
```
docker run -d -name jfrog -p 8081:8081 -p 8082:8082 docker.bintray.io/jfrog/artifactory-oss:latest
```
You may access the JFrog Artifactory portal from the Google Chrome browser on the RPS Cloud Lab machine
http://172.17.0.2:8081

When Artifactory prompts for password
```
user - admin
password - password
```
