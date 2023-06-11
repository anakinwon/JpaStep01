package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEacch() {
        repository.clearStore();
    }

    // 입력한 회의 검증하기.
    @Test
    public void save() {
        Member member = new Member();
        member.setName("anakin");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    // 회원 2명 입력 후 동일인물 검증하기.
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Anakin");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Anakin2");
        repository.save(member2);

        Member result = repository.findByName("Anakin").get();

        assertThat(result).isEqualTo(member1);
    }

    // 회원 2명 입력 후 size 검증하기.
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Anakin");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Anakin2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("Anakin3");
        repository.save(member3);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(3);
    }
}
