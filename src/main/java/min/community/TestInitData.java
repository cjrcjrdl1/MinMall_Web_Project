package min.community;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import min.community.domain.member.Member;
import min.community.domain.member.MemberRepository;
import min.community.domain.posts.Posts;
import min.community.domain.posts.PostsRepository;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
@RequiredArgsConstructor
public class TestInitData {

    private final PostsRepository postsRepository;
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Posts post = Posts.builder()
                .title("title")
                .author("author")
                .content("content")
                .build();

        postsRepository.save(post);

        Member member = Member.builder()
                .loginId("test")
                .name("tester")
                .password("test")
                .build();

        memberRepository.save(member);
    }
}
