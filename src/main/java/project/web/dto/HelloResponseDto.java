package project.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// dto ?
@Getter // 선언된 모든 필드에 get method 생성해줌
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성해줌. But, final 없는 필드는 안 만듬
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
