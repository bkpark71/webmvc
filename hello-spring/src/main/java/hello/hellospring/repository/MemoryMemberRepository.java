package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
// memberRepository를 빈으로 등록해서 스프링에게 알려주어 스프링컨테이너에
// 등록시키려면 @Repository를 넣어줘야 한다. 그럼 controller에 의해
// autowired 자동연결 처리된다.
// controller-service-repository 를 사용하는 것이 정형화된 방식이다.
// 즉 controller를 통해서 외부 요청을 받고,
// service에서 비즈니스 로직을 만들고
// repository에서 데이터저장을 하는 방식이다.
@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> map = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        map.put(member.getId(), member);
        //System.out.println(member);
        //System.out.println(store);
        return member;
    }

//    @Override
//    public Member findById(Long id) {
//        Member m =store.get(id);
//        if (m == null) {
//            m.setId(0L);
//            m.setName("anoymous");
//        }
//        return m;
//        //return Optional.empty();
//    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(map.get(id));
    }

//    @Override
//    public Optional<Member> findByName(String name) {
//// name과 일치하는 것 중 아무거나 반환하는데, optional이므로 null이면 null도 포함해서 반환한다.
////        System.out.println(map.values());
////        return Optional.empty();
//        return map.values().stream()
//                .filter(member -> member.getName().equals(name))
//                .findAny();
//    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(map.values());
    }

    public void clearMap() {
        map.clear();
    }
}
