package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 기능 구현.
//@Repository
public interface MemberRepository {

    // 회원 저장기능
    Member save(Member member);
    // 회원ID로 검색기능
    Optional<Member> findById(Long id);
    // 회원이름으로 검색기능
    Optional<Member> findByName(String name);
    // 회원전화번호로 검색기능
//    Optional<Member> findByTel(String tel);
    // 모든회원 검색기능
    List<Member> findAll();
}
