package com.miniFawry.couponapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition()
public class OpenApiConfig {

//    @Value("${coupon.openapi.dev-url}")
//    private String devUrl;
//
//    @Value("${coupon.openapi.prod-url}")
//    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("abdelazizasf@gmail.com");
        contact.setName("Abdelaziz");
        contact.setUrl("لما اعمل ويب سايت هحطه");

        License mitLicense = new License().name("مفيش حقوق .. اسرق براحتك").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Coupons API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage coupons.")
                .license(mitLicense);

        return new OpenAPI().info(info);
    }
}
