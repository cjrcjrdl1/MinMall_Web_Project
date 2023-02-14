package min.community.web.member.dto;

import lombok.Builder;
import lombok.Data;
import min.community.domain.member.Member;

@Data
public class MemberSaveRequestDto {

    private String loginId;
    private String name;
    private String password;

    @Builder
    public MemberSaveRequestDto(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

    public Member toEntity() {
        return Member.builder()
                .loginId(loginId)
                .name(name)
                .password(password)
                .build();
    }
}
