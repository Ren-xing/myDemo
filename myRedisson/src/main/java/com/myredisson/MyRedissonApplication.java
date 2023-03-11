package com.myredisson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.myredisson.mapper")
@SpringBootApplication
public class MyRedissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyRedissonApplication.class, args);
    }

}
