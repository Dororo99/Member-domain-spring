package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void finBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // 검증
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void finBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        // 검증
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 위 두가지는 모두 인터페이스로 조회!
    // 구체 타입으로 조회해보자
    @Test
    @DisplayName("구체 타입으로 조회")
    void finBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        // 검증
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    // 실패 테스트 케이스도 만들어 봐야해!!
    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByName(){
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxx", MemberService.class));
    }
}
