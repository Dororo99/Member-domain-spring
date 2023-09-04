package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    // 공연기획자
    // 배우를 교체하는 역할을 한다!
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    } // 의존관계 주입

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
 
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    } // OrderServiceImpl을 여기서 호출 함으로써 공연 기획자만 코드를 교체해주면 된다
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    } // DiscountPolicy 가 뭔지도 바로 알 수 있음!
}
