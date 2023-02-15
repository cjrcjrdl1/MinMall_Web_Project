package min.community.domain.posts;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import min.community.domain.BaseTimeEntity;

@Getter
@NoArgsConstructor
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

    @Column(nullable = false)
    private String author;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    @Builder
    public Posts(String title, String content, String author, int view) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.view = view;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
