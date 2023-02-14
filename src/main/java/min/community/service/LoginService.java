package min.community.service;

import lombok.RequiredArgsConstructor;
import min.community.domain.member.Member;
import min.community.domain.member.MemberRepository;
import min.community.domain.posts.Posts;
import min.community.web.member.dto.MemberLoginResponseDto;
import min.community.web.posts.dto.PostsResponseDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }

}
