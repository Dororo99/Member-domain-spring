package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // override by polymorphism
    private final MemberRepository memberRepository = new MemoryMemberRepository(); // OCP & DIP (X)

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}
