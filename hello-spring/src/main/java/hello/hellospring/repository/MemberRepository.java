package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 회원객체를 저장하기 위한 기능 구현
 * 인터페이스
 */


public interface MemberRepository {
    Member save(Member member);
    //Member findById(Long id);
    Optional<Member> findById(Long id);
    /* Optional<T> 클래스 */
    /* 없으면 null 을 그대로 반환하지 않고 optional 로 감싸서 처리 */
    //Optional<Member> findByName(String name);
    List<Member> findAll();
}
