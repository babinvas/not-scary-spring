package babinvas.notscaryspring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.java.rush.ChuckNorris;

@Configuration
@ComponentScan("babinvas.notscaryspring")
public class MyConfig {
	@Bean
	public ChuckNorris chuckNorris() {
		return new ChuckNorris();
	}
}
