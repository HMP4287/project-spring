package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.domain.posts.Posts;
import project.domain.posts.PostsRepository;
import project.web.dto.PostsListResponseDto;
import project.web.dto.PostsResponseDto;
import project.web.dto.PostsSaveRequestDto;
import project.web.dto.PostsUpdateRequestDto;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }
    // C U D 없는 서비스 메소드에서 사용 시 성능 개선.
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        // postsRepository 의 결과로 넘어온 Posts 의 스트림을 맵을 통해 PostsListResponseDto 로 변환하여 리스트로 반환하는 메소드.
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
