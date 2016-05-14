# Spring Security OAuth 2

## Configuration Conflicts
This project was created to demonstrate the issues that occur when both `WebSecurityConfigurerAdapter` and `ResourceServerConfigurerAdapter` set up `HttpSecurity` using each of their respective `configure(HttpSecurity http)` methods. Actually, as shown in this project, the moment resource server is enabled using `@EnableResourceServer`, the error occurs.

The `master` branch points to the version of the application that works (without resource server enabled). The `conflict` branch contains an example configuration that shows conflicts.

## Execution
This project uses Gradle for building. The quickest way to get the application running is to execute the `bootRun` Gradle task:

    ./gradlew bootRun

Alternatively, a jar file can be built using the `build` command. The resulting archive file is created in `build` directory. It can run using:

    java -jar build/libs/spring-security-conflict-0.0.1-SNAPSHOT.jar

