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
        Posts post1 = getPosts("1");
        Posts post2 = getPosts("2");
        Posts post3 = getPosts("3");
        Posts post4 = getPosts("4");
        Posts post5 = getPosts("5");
        Posts post6 = getPosts("6");
        Posts post7 = getPosts("7");
        Posts post8 = getPosts("8");
        Posts post9 = getPosts("9");
        Posts post10 = getPosts("10");
        Posts post11 = getPosts("11");

        postsRepository.save(post1);
        postsRepository.save(post2);
        postsRepository.save(post3);
        postsRepository.save(post4);
        postsRepository.save(post5);
        postsRepository.save(post6);
        postsRepository.save(post7);
        postsRepository.save(post8);
        postsRepository.save(post9);
        postsRepository.save(post10);
        postsRepository.save(post11);

        Member member = Member.builder()
                .loginId("test")
                .name("tester")
                .password("test")
                .build();

        memberRepository.save(member);
    }

    private static Posts getPosts(String title) {
        Posts post = Posts.builder()
                .title(title)
                .author("author")
                .content("content")
                .build();
        return post;
    }
}
