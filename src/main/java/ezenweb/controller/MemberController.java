package ezenweb.controller;

import ezenweb.model.dto.MemberDto;
import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
@CrossOrigin("http://localhost:3000") // 교차 리소스 공유 [해당 주소 = 리액트서버]
public class MemberController {

    @Autowired
    private MemberService memberService;


    // 1-1. [c] 회원가입
    @PostMapping("/post")
    public boolean postMember(@RequestBody MemberDto memberDto) {

        boolean result = memberService.postMember(memberDto);

        return result;
    }
    // 1-2 로그인
    @PostMapping("/login")
    public boolean login( @RequestBody MemberDto memberDto , HttpSession session) {

        boolean result = memberService.login(memberDto);

        return result;

    }



    // 2-1. [r] 회원정보 호출

    /*
    @GetMapping("/get")
    public MemberDto getMember(@RequestParam int mno){
        MemberDto memberDto = memberService.getMember( mno );

        return memberDto;ls
    }
    */
    // 2-1. [r] 회원정보 호출 [ 로그인된 ]
    @GetMapping("/get")
    public MemberDto getMember(){
        MemberDto memberDto = memberService.getMember();

        return memberDto;
    }

    // 2-2. 로그아웃
    @GetMapping("/logout")
    public boolean getMember( HttpSession session ){
        boolean result = memberService.logout( session );

        return result;
    }
    // 2-3. 아이디 찾기
    @GetMapping("/findById")
    public String findById(@RequestParam String mname, @RequestParam String mphone ) {

        String memail = memberService.findId( mname, mphone );

        return memail;
    }
    // 2-4. 비밀번호 찾기
    @GetMapping("/findByPassword")
    public String findByPassword(@RequestParam String memail, @RequestParam String mphone ) {

        String mpassword = memberService.findByPassword( memail, mphone );

        return mpassword;
    }

    // 3. [u] 회원정보 수정
    @PutMapping("/update")
    public boolean updateMember(@RequestBody MemberDto memberDto){
        boolean result = memberService.updateMember( memberDto );

        return result;
    }


    // 4. [d] 회원탈퇴
    @DeleteMapping("/delete")
    public boolean deleteMember(@RequestParam int mno){
        boolean result = memberService.deleteMember( mno );
        return result;
    }
}
