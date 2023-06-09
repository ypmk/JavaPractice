package sinforge.practice22.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {
        "sinforge.practice22.Repo"
})
@ComponentScan
public class DbConfig {}
