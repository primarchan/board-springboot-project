package com.primarchan.projectboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SpringbootProjectBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProjectBoardApplication.class, args);
    }

}
