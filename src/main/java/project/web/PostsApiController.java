package project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.service.PostsService;
import project.web.dto.PostsResponseDto;
import project.web.dto.PostsSaveRequestDto;
import project.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor // final 선언된 필드 생성자 만들어줌 ->
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
