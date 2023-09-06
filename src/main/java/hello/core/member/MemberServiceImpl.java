package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // ("memberService2") 왠만하면 디폴트 값을 쓰자
public class MemberServiceImpl implements MemberService {

    // override by polymorphism
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // DIP (X): 고수준인 interface가 저수준인 class에 의존하고 있음
    // OCP (X): 기능 확장시 코드를 수정해야 함! 의존중이기 때문임)
    private final MemberRepository memberRepository;

    @Autowired // @Component가 되면 스캔될 때, 자동으로 빈이 등록되므로 자동으로 의존관계를 주입시켜 줘야 한다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // 구현체에 뭐가 들어갈지는 생성자를 통해서!

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }

    //TEST
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
