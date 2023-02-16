package min.community.web.member;

import lombok.RequiredArgsConstructor;
import min.community.service.MemberService;
import min.community.web.member.dto.MemberRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") MemberRequestDto member) {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute("member") MemberRequestDto member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        memberService.save(member);
        return "redirect:/";
    }
}
