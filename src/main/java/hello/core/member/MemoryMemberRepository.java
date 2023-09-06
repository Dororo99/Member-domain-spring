package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // 사실 concurrentHashMap 사용이 맞다 (동시성 이유)
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findByID(Long memberId) {
        return store.get(memberId);
    }
}
