package min.community.domain.posts;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import min.community.domain.BaseTimeEntity;
import min.community.domain.member.Member;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @NotNull
    @Column(length = 500)
    private String title;


    @NotNull
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private String author;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
