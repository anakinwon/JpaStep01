package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest   // 실제로 스프링부트를 구동해서 테스트한다.
//@Transactional  // Test 시에는 Rollback 되도록 설정한다.
public class MemberServiceIntTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given : 주어진 상황
        Member member = new Member();
        member.setName("anakin123");

        // when : 실행된 조건
        Long saveId  = memberService.Join(member);

        // then : 기대되는 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원테스트() {
        // given : 주어진 상황
        Member member1 = new Member();
        member1.setName("anakin");

        Member member2 = new Member();
        member2.setName("anakin");

        // when : 실행된 조건
        memberService.Join(member1);
//        try {
//            memberService.Join(member2);
//            //fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름으로 가입 불가합니다.");
//        }

        // assertThrows(IllegalStateException.class, () -> memberService.Join(member2));
        // Ctrl + Alt + V
        IllegalStateException e  = assertThrows(IllegalStateException.class, () -> memberService.Join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름으로 가입 불가합니다.");

    }

}
