package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    /**
     * 홈에서 회원가입을 누르면 이 메소드에서 처리해줌
     */
    @GetMapping("members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

}
