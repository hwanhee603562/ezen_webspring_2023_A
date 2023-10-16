package ezenweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing      // JPA Auditing
@SpringBootApplication
public class EzenWebStart {

    public static void main(String[] args) {
        SpringApplication.run( EzenWebStart.class );
    }

}
