package com.sword.api.common.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author zhangjian
 * @Date 2017/2/20
 * @Copyright:
 * @Describe:
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sword.api.upm"})
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户权限管理系统API")
                .description("此API用户于用的权限系统")
                .version("1.0")
                .termsOfServiceUrl("#")
                .license("LICENSE")
                .licenseUrl("")
                .build();
    }

}
