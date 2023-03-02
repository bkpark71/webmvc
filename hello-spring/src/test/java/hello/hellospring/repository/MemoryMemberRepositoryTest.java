package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    /**
     * 테스트는 각각 의존관계가 없이 각각 실행되도록 해야 한다.
     * 그러기 위해서 테스트가 하나 끝날때마다 공용데이터를 클리어해야 함.
     */
    @AfterEach
    public void AfterEach(){
        repository.clearMap();
    }

    @Test
    public void save(){ // 저장하고 저장된 것을 꺼내서 비교
        Member member = new Member();
        member.setName("Spring1");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //System.out.println(result == member);
        //Assertions.assertEquals(member, null); // junit 의 Assertions
        assertThat(member).isEqualTo(result);//(assertj 에 있는 assertions 이용) => 그 후 alt+enter누르고 static 으로 만들면 Assertions 생략하고 사용 가능

    }

//    @Test
//    public void findByName(){
//        Member member1 = new Member();
//        member1.setName("Spring1");
//        repository.save(member1);
//
//        Member member2  = new Member();
//        member2.setName("Spring2");
//        repository.save(member2);
//
//        // 오른쪽만 입력하고 alt+enter 누르면 지역변수 자동생성됨.
//        //Member result = repository.findByName("Spring2").get();
//        assertThat(result).isEqualTo(member2);
//    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2  = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> all = repository.findAll();
        assertThat(all.size()).isEqualTo(2);
    }

}
