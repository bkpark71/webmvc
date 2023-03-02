package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    // 등록되어 있는 모든 멤버의 기록을 전부 초기화하기 위해 repository 선언
    MemoryMemberRepository memberRepository ;

    @BeforeEach
    public void BeforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void AfterEach(){
        memberRepository.clearMap();
    }

    /**
     * 테스트의 경우에는 메소드 이름 한글로 줘도 된다.
     * 배포시에 테스트코드는 포함되지 않는다.
     */
    @Test
    void memberjoin() {  // 정상적인 경우의 테스트
        //given -- 어떤 데이터가 주어지면
        Member member = new Member();
        member.setName("Spring");

        //when -- 멤버정보를 저장하면
        long saveId = memberService.join(member);
        //then
        Member result = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(result.getName());
    }
    // 예외적인 경우로 걸러내는지를 반드시 테스트해야 한다.
    @Test
    void validateDupJoin() {  // 중복회원 예외 테스트
        //given -- 어떤 데이터가 주어지면
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");
        //when -- 멤버정보를 저장하면
        memberService.join(member1);
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class,
            () -> memberService.join(member2));

//        try{
//            memberService.join(member2);
//            fail();
//        }catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
//        }
        //then

    }

    private void fail() {
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}