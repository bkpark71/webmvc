package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 작성후 클래스명 선택 후 control + shift + t 누르면 자동으로 테스트 케이스 생성해줌.

// memberService를 빈으로 등록해서 스프링에게 알려주어 스프링컨테이너에
// 등록시키려면 @Service를 넣어준다. 마찬가지로 repository 클래스도 스프링컨테이너에
// 등록시키려면 @Repository를 넣어줘야 한다.
// @Service 에사 control + 마우스클릭 해보면 그 안에 @Component 도 등록되어 있다.
//@Service
public class MemberService {
    private final MemberRepository memberRepository;

    // 생성자를 통해 외부에서 넣어준 인자를 가지고 memberRepository가 생성되도록 한다.
    // 의존관계 설정을 위해 MemberService 생성자에도 @Autowired를 넣어줘야 한다.
//    @Autowired
    public MemberService(MemberRepository memberRepository){

        this.memberRepository = memberRepository;
    }
    /**
     * 회원 가입
     * @param member
     * @return
     */
    public long join(Member member) {
        //같은 이름 제외라는 룰 적용
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원");
//        });  작성후 alt+enter 누르면 extract method 로 별도 method로 작성됨
        //memberDuplicateValidate(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 중복된 이름의 멤버 있는지 검증
     * @param member
     */
//    private void memberDuplicateValidate(Member member) {
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원");
//                });
//    }
    /**
     * 전체회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
