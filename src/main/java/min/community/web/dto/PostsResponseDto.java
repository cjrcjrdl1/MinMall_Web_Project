package min.community.web.dto;

import lombok.Builder;
import lombok.Getter;
import min.community.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
