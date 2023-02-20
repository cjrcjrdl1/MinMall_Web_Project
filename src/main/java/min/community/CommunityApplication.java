package min.community;

import min.community.domain.member.Member;
import min.community.domain.posts.Posts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class CommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
//		Member member = Member.builder()
//				.loginId("abc")
//				.password("abc")
//				.name("abc")
//				.build();
//
//		Posts post = Posts.builder()
//				.title("a")
//				.content("a")
//				.author("a")
//				.view(1)
//				.member(member)
//				.id(1L)
//				.build();
//
//		String name = post.getMember().getName();
//
//		System.out.println("name = " + name);
	}

}
