package by.pochepko.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("by.pochepko.dao")
@EntityScan(basePackages = "by.pochepko.model")
public class SpringBtApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBtApplication.class, args);

    }
}
