package min.community.web.posts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import min.community.domain.member.Member;
import min.community.domain.posts.Posts;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsRequestDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    private int view;
    private Member member;


    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .member(member)
                .view(view)
                .build();
    }
}
