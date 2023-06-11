package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

    // 회원 리포지토리를 먼저 만든다.
    private final MemberRepository memberRepository;// = new MemoryMemberRepository();

    // 외부에서 생성할 수 있도록 한다.
//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     *
     */
    public Long Join(Member member) {
        // 같은 이름으로 가입 불가 로직
        validateName(member);

        memberRepository.save(member);
        return member.getId();
    }


    // 같은 이름으로 가입 불가 로직
    private void validateName(Member member) {
        // 자동 생성 단축키 = Ctrl+ Alt + v
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 이름으로 가입 불가합니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원명으로 검색하기.
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
