package min.community.service;

import lombok.RequiredArgsConstructor;
import min.community.domain.posts.Posts;
import min.community.domain.posts.PostsRepository;
import min.community.web.dto.PostsListResponseDto;
import min.community.web.dto.PostsResponseDto;
import min.community.web.dto.PostsSaveRequestDto;
import min.community.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getAuthor());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAll() {
//        List<Posts> posts = postsRepository.findAll();
//        List<PostsResponseDto> responseDtos = new ArrayList<>();
//
//        for (Posts post : posts) {
//            PostsResponseDto postsResponseDto = new PostsResponseDto(post);
//            responseDtos.add(postsResponseDto);
//        }
//
//        return responseDtos;
        return postsRepository.findAll().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
