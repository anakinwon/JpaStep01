<빌드하고 자체서버 구동하기>

1. 0CLI에서 자바 빌드하기
    - D:\hellospring> gradlew.bat build

2. CLI에서 스프링부트(톰캣) 실행하기.
    - D:\hellospring\build\libs> java -jar hellospring-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v2.7.11)

2023-05-11 11:09:02.412  INFO 11972 --- [           main] h.hellospring.HellospringApplication     : Starting HellospringApplication using Java 11.0.17 on DESKTOP-A7UIT2R with PID 11972 (D:\hellospring\build\libs\hellospring-0.0.1-SNAPSHOT.jar started by anakin in D:\hellospring\build\libs)
2023-05-11 11:09:02.416  INFO 11972 --- [           main] h.hellospring.HellospringApplication     : No active profile set, falling back to 1 default profile: "default"
2023-05-11 11:09:04.696  INFO 11972 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-05-11 11:09:04.722  INFO 11972 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-05-11 11:09:04.722  INFO 11972 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.74]
2023-05-11 11:09:04.849  INFO 11972 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-05-11 11:09:04.850  INFO 11972 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2345 ms
2023-05-11 11:09:05.173  INFO 11972 --- [           main] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page: class path resource [static/index.html]
2023-05-11 11:09:05.359  INFO 11972 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-05-11 11:09:05.371  INFO 11972 --- [           main] h.hellospring.HellospringApplication     : Started HellospringApplication in 3.525 seconds (JVM running for 3.955)
2023-05-11 11:09:16.849  INFO 11972 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-05-11 11:09:16.850  INFO 11972 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-05-11 11:09:16.851  INFO 11972 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2023-05-11 11:09:23.586  INFO 11972 --- [nio-8080-exec-3] LoggerController 의 로그                    : 로깅 발생!


<H2-DB 소켓으로 접속하기>

jdbc:h2:tcp://localhost/~/test