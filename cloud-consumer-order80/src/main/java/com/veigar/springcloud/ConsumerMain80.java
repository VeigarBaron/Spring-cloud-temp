package com.veigar.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author VeigarBaron
 * @date 2020/10/20 14:49
 * @Description *
 */
@SpringBootApplication
@EnableEurekaServer
public class ConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain80.class, args);
    }
}