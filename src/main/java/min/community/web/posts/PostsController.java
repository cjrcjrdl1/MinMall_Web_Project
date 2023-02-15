package min.community.web.posts;

import lombok.RequiredArgsConstructor;
import min.community.domain.posts.Posts;
import min.community.domain.posts.PostsRepository;
import min.community.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/posts")
@Controller
public class PostsController {

    private final PostsService postsService;
    private final PostsRepository postsRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("posts", postsRepository.findAllDesc());
        return "posts/postsList";
    }

    @GetMapping("/save")
    public String postsSave() {
        return "posts/postsSave";
    }

    @PutMapping("/save")
    public String postsSaved() {
        return "posts/postsList";
    }

    @GetMapping("/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        Optional<Posts> dto = postsRepository.findById(id);
        postsService.updateView(id);
        model.addAttribute("post", dto);

        return "posts/postsUpdate";
    }


}
