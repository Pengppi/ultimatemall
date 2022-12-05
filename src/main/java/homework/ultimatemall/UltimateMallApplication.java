package homework.ultimatemall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UltimateMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(UltimateMallApplication.class, args);
    }

}
