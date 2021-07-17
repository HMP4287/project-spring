package project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정 함. 프로젝트의 최상단에 위치할 것
@EnableJpaAuditing
@SpringBootApplication
// 메인 클래스
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 웹 애플리케이션 서버 실행
    }
}
