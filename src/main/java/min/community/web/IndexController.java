package min.community.web;

import lombok.RequiredArgsConstructor;
import min.community.domain.posts.Posts;
import min.community.domain.posts.PostsRepository;
import min.community.service.PostsService;
import min.community.web.dto.PostsSaveRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final PostsRepository postsRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Posts> posts = postsRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @PutMapping("/posts/save")
    public String postsSaved() {
        return "index";
    }
}
