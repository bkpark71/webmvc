package hello.hellospring.domain;

/**
 * 고객 정보를 저장하기 위한 도메인
 */
public class Member {
    private Long id;
    private String name;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
