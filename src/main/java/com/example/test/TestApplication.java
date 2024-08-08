package com.example.test;

import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;

@SpringBootApplication
@EnableRabbit
public class TestApplication {

    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext application = SpringApplication.run(TestApplication.class, args);

            System.out.println("==========启动成功============");

            ConfigurableEnvironment env = application.getEnvironment();

            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = env.getProperty("server.port");
            String path = env.getProperty("server.servlet.context-path");

            System.out.println("" +
                    "Local:http://localhost:" + port+ StringUtils.trimToEmpty(path));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
