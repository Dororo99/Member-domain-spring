package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // override by polymorphism
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // DIP (X): 고수준인 interface가 저수준인 class에 의존하고 있음
    // OCP (X): 기능 확장시 코드를 수정해야 함! 의존중이기 때문임)

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}
