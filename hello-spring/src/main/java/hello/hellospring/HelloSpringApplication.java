package hello.hellospring;
// @ComponentScan 대상은 main이 등록되어 있는 hellospring 패키지 아래에 있는 것만
// 뒤지게 된다. 다른 패키지를 등록하면 그 패키지는 component 로 찾지 않는다.
// @component 등록은 싱글톤(패키지에 유일하게 하나만 등록한다.)으로 등록한다.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
