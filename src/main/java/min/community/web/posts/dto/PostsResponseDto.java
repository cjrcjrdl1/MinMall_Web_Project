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
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private int view;
    private Member member;


    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.view = entity.getView();
        this.member = entity.getMember();
    }
}
