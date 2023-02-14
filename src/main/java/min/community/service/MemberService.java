package min.community.service;

import lombok.RequiredArgsConstructor;
import min.community.domain.member.Member;
import min.community.domain.member.MemberRepository;
import min.community.web.member.dto.MemberLoginResponseDto;
import min.community.web.member.dto.MemberSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberSaveRequestDto requestDto) {
        memberRepository.save(requestDto.toEntity());
    }

    public MemberLoginResponseDto findById(Long id) {
        Member entity = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 맴버가 없습니다. id=" + id));
        return new MemberLoginResponseDto(entity);
    }

}
