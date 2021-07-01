package project.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 을 반환하는 컨트롤러로 만듬 -> ?
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}