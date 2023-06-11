package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellospringApplication {

	// D:\hellospring\H2\bin\ h2.bat    <= DB먼저 Start하고 실행 할 것. : http://localhost:8080/
	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}

}
