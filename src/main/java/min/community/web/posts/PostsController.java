package min.community.web.posts;

import lombok.RequiredArgsConstructor;
import min.community.domain.posts.Posts;
import min.community.domain.posts.PostsRepository;
import min.community.service.PostsService;
import min.community.web.member.dto.MemberResponseDto;
import min.community.web.posts.dto.PostsResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    private final PostsRepository postsRepository;

    @GetMapping
    public String index(Model model,
                        @PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        Page<Posts> posts = postsService.pageList(pageable);
        model.addAttribute("posts", posts);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", posts.hasNext());
        model.addAttribute("hasPrev", posts.hasPrevious());
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

    @GetMapping("/read/{id}")
    public String postsRead(@PathVariable Long id, MemberResponseDto member, Model model) {
        PostsResponseDto dto = postsService.findById(id);

        if (member != null) {
            model.addAttribute("member", member);

            if (dto.getAuthor().equals(member.getName())) {
                model.addAttribute("memberCheck", true);
            }
        }

        model.addAttribute("post", dto);

        return "posts/postsRead";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, MemberResponseDto member, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        if (member != null) {
            model.addAttribute("member", member);
        }
        postsService.updateView(id);
        model.addAttribute("post", dto);
        return "posts/postsUpdate";
    }


}
