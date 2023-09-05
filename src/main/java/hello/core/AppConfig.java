package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Spring으로 변경해보자
@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    // 여기서만 봐도 MemoryMemberRepository가 두번 호출됨!
    // 싱글톤이 깨지는거 아냐?
    @Bean
    // 공연기획자
    // 배우를 교체하는 역할을 한다!
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    } // 의존관계 주입
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    } // OrderServiceImpl을 여기서 호출 함으로써 공연 기획자만 코드를 교체해주면 된다
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    } // DiscountPolicy 가 뭔지도 바로 알 수 있음!
}
