package com.example.GrandWorldM.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-15T19:26:30.495+08:00")

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Grand World.")
            .description("A ambicious project.")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("zht","", "heting.zhao@qq.com"))
            .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //当接口与实现类在同一个工程下时，这里包的路径要指到实现接口的类的包或者父包，而不是接口的包
                    .apis(RequestHandlerSelectors.basePackage("com.example.GrandWorldM"))
                    .build()
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

}
