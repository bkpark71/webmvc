package hello.hellospring;

import javax.sql.DataSource;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// autowired - service - repository 구조로 사용하지 않고
// 직접 java bean 으로 등록해주려면 configuration 파일을 등록해줘야 한다.
// Config 파일에 있는 빈들을 직접 스프링 컨테이너에 등록해줬기 때문에
// autowired에 의해 연결 될 수 있다.

@Configuration
public class SpringConfig {

    private final DataSource datasource;

    @Autowired
    public SpringConfig(DataSource datasource) {
        // 이 datasource 를 이용해 db connection 등의 작업을 할 수 있다.
        this.datasource = datasource;
    }

    // 생성자에 어떤 것을 넣어야하는지 자동으로 보려면 control+p 하면 된다.
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        // DB가 결정되지 않아서 임시로 사용하던 repository 대신
        // jdbcTemplateMemberRepository를 사용하도록 한다.
        // 다른 코드 하나도 수정하지 않아도 repository가 변경되었다.
        //return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(datasource);
    }

}
