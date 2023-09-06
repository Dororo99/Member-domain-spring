package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // AppConfig안의 Bean이 이중등록 될수 있어서 빼기 위함! (기존 예제 코드를 남기고 유지하기 위해서)
) // 자동으로 컴포넨트를 긁어오는거
public class AutoAppConfig {

}
