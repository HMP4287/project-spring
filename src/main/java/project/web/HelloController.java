package project.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.web.dto.HelloResponseDto;

@RestController // JSON 을 반환하는 컨트롤러로 만듬 -> ?
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("hello/dto")
    public HelloResponseDto hellloDto (@RequestParam("name") String name, @RequestParam("amount") int amount) { // Requset Param으로 입력받아 객체 생성 후 리턴
        return new HelloResponseDto(name, amount);
    }
}