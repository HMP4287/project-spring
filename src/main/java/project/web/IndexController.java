package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.config.auth.LoginUser;
import project.config.auth.dto.SessionUser;
import javax.servlet.http.HttpSession;
import project.service.PostsService;

import org.springframework.ui.Model;
import project.web.dto.PostsResponseDto;

@RequiredArgsConstructor // final 생성자 생성
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    // UserLogin 어노테이션 추가 전
//    @GetMapping("/")
//    public String index(Model model) {
//        // Model -> 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음.
//        // posts로 index.mustache로 전달
//        model.addAttribute("posts", postsService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        if (user != null)
//            model.addAttribute("userName", user.getName());
//
//        return "index";
//    }
    // UserLogin 어노테이션 추가 후
    public String index(Model model, @LoginUser SessionUser user) {
        // Model -> 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음.
        // posts로 index.mustache로 전달
        model.addAttribute("posts", postsService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null)
            model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
