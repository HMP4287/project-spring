package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.service.PostsService;

import org.springframework.ui.Model;
@RequiredArgsConstructor // final 생성자 생성
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        // Model -> 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음.
        // posts로 index.mustache로 전달
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
