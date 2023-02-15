package min.community.web.posts.dto;

import lombok.Data;
import min.community.domain.posts.Posts;

@Data
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private int view;


    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.view = entity.getView();
    }
}
