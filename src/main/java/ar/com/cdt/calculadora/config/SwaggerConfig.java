package ar.com.cdt.calculadora.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.title}")
    public String title = null;
    @Value("${swagger.description}")
    public String description = null;
    @Value("${swagger.version}")
    public String version = null;
    @Value("${swagger.termsOfServiceUrl}")
    public String termsOfServiceUrl = null;
    @Value("${swagger.contactName}")
    public String contactName = null;
    @Value("${swagger.contactUrl}")
    public String contactUrl = null;
    @Value("${swagger.contactMail}")
    public String contactMail = null;
    @Value("${swagger.license}")
    public String license = null;
    @Value("${swagger.licenseUrl}")
    public String licenseUrl = null;

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*"))).build().apiInfo(metaData());
    }

    private ApiInfo metaData() {
        Contact contact = new Contact(contactName, contactUrl, contactMail);
	    return new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl, new ArrayList<>());
    }
}
