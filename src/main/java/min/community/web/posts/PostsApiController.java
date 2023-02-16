package min.community.web.posts;

import lombok.RequiredArgsConstructor;
import min.community.service.PostsService;
import min.community.web.member.dto.MemberRequestDto;
import min.community.web.posts.dto.PostsResponseDto;
import min.community.web.posts.dto.PostsRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsRequestDto requestDto, MemberRequestDto memberDto) {
        return postsService.save(memberDto.getName(), requestDto);
    }

    @PutMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
