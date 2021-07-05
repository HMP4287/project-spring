package project.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.is; //위 is는 틀리다. 왜

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class) // 테스트 진행 시 JUnit에 내장된 실행자 외에 다른 실행자를 실행 시킴
@WebMvcTest(controllers = HelloController.class) // 스프링 테스트 어노테이션들 중 Web(spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는, 빈을 주입받는다.
    private MockMvc mvc; // 스프링 MVC테스트의 시작.  HTTP GET, POST 등 API 테스트 가능해짐

    // 세팅에서 gradle-> test를 intellij 로 실행으로 변경하여 해결
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        System.out.println(hello);

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello주소로 HTTP GET 요청 한다. 체이닝 지원되어 여러 검증 기능 이어서 선언 가능
            .andExpect(status().isOk()) // HTTP Header Status check ex) 200
            .andExpect(content().string(hello));// 응답 본문의 내용 검사. 컨트롤러에서 헬로를 리턴하기 떄문에 그 값이 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 100;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
