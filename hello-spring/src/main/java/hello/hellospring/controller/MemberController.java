package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemberForm;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// controller annotation이 있으면 스프링컨테이너라는 통이 생기고
// memberController를 생성해서 통해 넣어두고 스프링이 관리를 하게 된다.
// memberService 를 new로 생성해서 사용해도 되지만
// 스프링 컨테이너에 하나만 등록해놓고 컨테이너로부터 받아서 사용하는 것으로 하는 것이 좋다.
// 여러 다른 서비스 즉 주문서비스에서도 멈버서비스를 가져다 쓸수도 있기 때문이다.
// 즉, 기능도 몇개 안되니 하나만 생성해놓고 공용으로 사용하면 되는 것이다.
// 생성자를 통해 등록되도록 하고 @Autowired 어노테이션을 사용한다.
// @Autowired 가 선언되어 있으면 컨테이너에 등록되어 있는 memberService를 찾아서
// 자동으로 연결을 시켜준다. 동시에 memberService로 bean으로 등록이 되어져 있어야 한다.
@Controller
public class MemberController {
    private MemberService memberService = null;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        //System.out.println("member : "+ form.getName());
        return "redirect:/";
    }

    /**
     * 회원목록보기 를 누르면 이 메소드에서 처리해줌
     * @return
     */
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}

