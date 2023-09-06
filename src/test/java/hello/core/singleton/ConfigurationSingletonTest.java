package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService --> memberRepository1 = " + memberRepository1);
        System.out.println("orderService --> memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository2 = " + memberRepository);
        // 3개 모두 같은 객체를 공유한다

        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    }
    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        // 얘도 스프링 빈으로 등록된다!
        // AppConfig를 임의로 상속 받아 클래스를 하나 만들고 스프링 컨테이너에 임의로 등록해버림! -> 얘가 싱글톤 보장!
        // 상속 받은 클래스는 AppConfig@CGLIB
        System.out.println("bean = " + bean.getClass());
        // @Configuration이 없으면 CGLIB로부터 생성 x
        // 이렇게 되면 다른 싱글톤이 고장남
    }
}