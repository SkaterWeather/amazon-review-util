package team.five.amazonreviewutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "team.five.amazonreviewutil" },
        exclude = { ErrorMvcAutoConfiguration.class })
public class AmazonReviewUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazonReviewUtilApplication.class, args);
    }

}
