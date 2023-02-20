package min.community.web.posts;

import lombok.RequiredArgsConstructor;
import min.community.domain.member.Member;
import min.community.domain.posts.Posts;
import min.community.domain.posts.PostsRepository;
import min.community.service.PostsService;
import min.community.web.member.dto.MemberRequestDto;
import min.community.web.member.dto.MemberResponseDto;
import min.community.web.posts.dto.PostsResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/posts")
@Controller
public class PostsController {

    private final PostsService postsService;
    private final PostsRepository postsRepository;

    @GetMapping
    public String index(Model model,
                        @PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable, Member member) {
        Page<Posts> posts = postsService.pageList(pageable);

//        List<Posts> posts = postsRepository.findAll();
        if (member != null) {
            model.addAttribute("member", member);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("posts", posts);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", posts.hasNext());
        model.addAttribute("hasPrev", posts.hasPrevious());
        return "posts/postsList";
    }

    @GetMapping("/save")
    public String postsSave(@ModelAttribute MemberResponseDto member, Model model) {
        if (member != null) {
            model.addAttribute("member", member);
        }
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
        postsService.updateView(id);
        model.addAttribute("post", dto);

        return "posts/postsRead";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, MemberResponseDto member, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        if (member != null) {
            model.addAttribute("member", member);
        }
        model.addAttribute("post", dto);
        return "posts/postsUpdate";
    }


}
