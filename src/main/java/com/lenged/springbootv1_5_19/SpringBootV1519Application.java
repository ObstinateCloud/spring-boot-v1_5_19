package com.lenged.springbootv1_5_19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringBootV1519Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootV1519Application.class, args);
    }

}
