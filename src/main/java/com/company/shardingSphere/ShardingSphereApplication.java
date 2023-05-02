package com.company.shardingSphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.company.shardingSphere.mapper"})
public class ShardingSphereApplication {
    public static void main(String[] args){
        SpringApplication.run(ShardingSphereApplication.class, args);
    }
}
