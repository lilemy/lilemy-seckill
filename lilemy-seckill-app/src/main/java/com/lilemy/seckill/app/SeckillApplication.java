package com.lilemy.seckill.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 秒杀服务启动类
 *
 * @author lilemy
 * @date 2026-06-18 17:07
 */
@SpringBootApplication
@ComponentScan({"com.lilemy.seckill.*"})
@MapperScan("com.lilemy.seckill.**.mapper")
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }
}
