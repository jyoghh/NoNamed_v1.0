package jiho.marvel01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Marvel01Application {

    public static void main(String[] args) {
        SpringApplication.run(Marvel01Application.class, args);
    }

}
