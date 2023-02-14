package min.community.web.posts;

import lombok.RequiredArgsConstructor;
import min.community.service.PostsService;
import min.community.web.posts.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/posts")
@Controller
public class PostsController {

    private final PostsService postsService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "post-list";
    }

    @GetMapping("/save")
    public String postsSave() {
        return "posts-save";
    }

    @PutMapping("/save")
    public String postsSaved() {
        return "post-list";
    }

    @GetMapping("/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
