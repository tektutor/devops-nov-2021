### What is Maven?
- is a build tool
- used by Java projects
- Ant was the build tool that was used prior to Maven
- Maven is an opensource tool just like Ant
- Both Ant and Maven are developed and maintained by Apache Foundation
- Apache Ant
    - doesn't support dependency management
    - doesn't have any standard convention for project directory structure
    - build.xml - you need to write all the build instructions
    - xml is not a suitable format to capture build instructions
    - for complex projects, the build.xml file grows to an extent that not everyone can understand. Maintainence of build.xml
      for complex projects becomes a nightmare
- Apache Ant uses a file called build.xml
- Apache Foundation wanted to solve all the isssues they faced in Ant by developing a new build tool called Maven
- Apache Maven
   - has conventions for pretty everything
   - has conventions for 
   -   where to keep your application source code
   -   where to keep your application test
   -   how to name your projects components
   - supports dependency management
   - Maven Co-ordinates
      - groupId - is a reverse domain name of your organization ( tektutor.org is the domain, then reverse domain is org.tektutor)
      - artifactId - the name of the jar/war/ear/zip/tar 
      - version - your module/component version
         - 1.2.3
         - 1 represents the major version
         - 2 represents the minor version
         - 3 represents the incremental version

- Maven - convention over configuration (80 - 20 Principle)
   - Maven co-ordinates
- Maven Repositories
  - maintains a collection of artifacts (third-party libraries)
  - organized using Maven co-ordinate folder-structure
  - Sonatype(Organization) - Nexus (Product)
  - JFrog(Organization) - Artifactory (Product)
  - 3 types
     - Maven Central Repository ( Website maintained by Apache Foundation - Sonatype Nexus 
     - Maven Private Repository ( to maintain your organization proprietary artifacts - jar,war,ear,zip,tar,etc )
     - Maven Local Repository ( is a directory created automatically by Maven in your system )
        - User Home Directory - creates .m2 directory

### Maven Super POM (Project Object Model)
- Every pom file that we write they automatically inherit from Super POM
- Super POM comes out of the box when you install Maven
- Super POM has the default configurations

### Effective POM
- is a combination of super pom with your pom configuration 
- maven always generates an effective pom in the memory(RAM) before it does anything on your project

### Maven Dependencies
- are nothing but third-party frameworks used by your project
- e.g JUnit, Log4J are dependencies for your project

### Maven Plugins
- Maven depends on plugins to perform compilation, cleaning target folder, packaging your binaries as jar,war,ear, zip, etc
- Plugins are Maven's dependencies
- Maven uses maven-compiler-plugin to compile your application code ( compile goal to compile application code )
- Maven uses maven-compiler-plugin to compile your automated test cases (testCompile goal to compile automated test case code)
- Maven plugins has one or more goals
- Each plugin goal does one specific task like compiling app code, compiling test code, packaging jar file, deployg jar files, etc


