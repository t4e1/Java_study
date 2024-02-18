package com.studyreview.springbootreview.member;

import com.studyreview.springbootreview.common.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    @GetMapping("/member/registMember")
    public String registNewMember() {
        return "regist";
    }

    @PostMapping("/member/registMember")
    public String registNewMember(@ModelAttribute("member") MemberDTO member) {

        System.out.println(member);
//        MemberService.registNewMember(member);

        return "print/regist";
    }
}
