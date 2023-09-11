package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 시작 지점을 설정할 수 있음
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // AppConfig안의 Bean이 이중등록 될수 있어서 빼기 위함! (기존 예제 코드를 남기고 유지하기 위해서)
) // 자동으로 컴포넨트를 긁어오는거
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    } // 이렇게 하면 자동 빈보다 수동 빈이 우선권을 갖기 때문에 수동빈이 자동빈을 오버라이딩한다.
}
