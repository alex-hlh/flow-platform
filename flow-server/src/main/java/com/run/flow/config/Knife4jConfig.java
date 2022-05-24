package com.run.flow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName: Knife4jConfig
 * @Description:
 * @Author: hlh
 * @Date: 2022-05-21 22:47
 */
@Configuration
@EnableOpenApi
public class Knife4jConfig {
	@Bean
	public Docket docket() {
		Docket docket = new Docket(DocumentationType.OAS_30)
				.apiInfo(new ApiInfoBuilder()
						.title("流程平台系统")
						.description("个人项目")
						// .termsOfServiceUrl("http://www.xx.com/")
						//.contact(new Contact("knife", "https://knife.blog.csdn.net/", "xx@qq.com"))
						.version("1.0")
						.build())
				// 分组名称
				.groupName("all")
				.select()
				// 这里指定Controller扫描包路径
				.apis(RequestHandlerSelectors.basePackage("com.run.flow.controller"))
				.paths(PathSelectors.any())
				.build();

		return docket;
	}

}
