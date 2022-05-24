package com.run.flow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: FlowServceApplication
 * @Description:
 * @Author: hlh
 * @Date: 2022-05-21 15:54
 */
@SpringBootApplication
@MapperScan("com.run.flow.mapper")
public class FlowServceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlowServceApplication.class, args);
	}
}
