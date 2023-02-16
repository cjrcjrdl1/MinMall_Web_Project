package min.community.domain.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import min.community.domain.BaseTimeEntity;
import min.community.domain.posts.Posts;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;


    @Builder
    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

}
