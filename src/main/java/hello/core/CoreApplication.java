package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// client -> MemberServiceImpl -> MemoryMemberRepository

@SpringBootApplication // spring boot 사용하면 자동으로 project root 하위를 scan한다
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
