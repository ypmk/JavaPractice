package sinforge.practice19.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {
        "sinforge.practice19.Repo"
})
@ComponentScan
public class DbConfig {}
