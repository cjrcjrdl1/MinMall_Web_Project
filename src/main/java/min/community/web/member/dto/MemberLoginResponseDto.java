package min.community.web.member.dto;

import lombok.Builder;
import lombok.Data;
import min.community.domain.member.Member;

@Data
public class MemberLoginResponseDto {

    private String name;

    public MemberLoginResponseDto(Member entity) {
        this.name = entity.getName();
    }
}
