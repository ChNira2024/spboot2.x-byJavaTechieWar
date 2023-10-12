package com.nt.niranjana.spboot2x.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableSwagger2
@OpenAPIDefinition
public class SwaggerDocsConfig 
{
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	private ApiKey apiKeys()
	{
		return new ApiKey("JWT",AUTHORIZATION_HEADER,"header");
	}

	private SecurityContext securityContext() 
	{
        return SecurityContext.builder()
                .securityReferences(securityReference())
                .build();
    }

    List<SecurityReference> securityReference() 
    {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
	@Bean
	 public   Docket createDocket() 
	{
		   return  new Docket(DocumentationType.SWAGGER_2)  //UI screen type
				   .securityContexts(Arrays.asList(securityContext()))
	                .securitySchemes(Arrays.asList(apiKeys()))
				              .select()  //to specify  RestControllers
				              .paths(PathSelectors.any())
				              .apis(RequestHandlerSelectors.basePackage("com.nt.niranjana.spboot2x")) //base pkg 
				               // to specify request paths
				              .build().apiInfo(documentationInfo()); // builds the Docket obj	
	}
	private ApiInfo documentationInfo()
    {   	
        return new ApiInfoBuilder().title("Spring Boot2x Swagger Request API")
                .description("Spring Boot2x-ByJavaTechie all the possibility integration")
                .contact(new Contact("Dev-Niranjana", "https://www.payment.example.com/", "niranjanacharty2013@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();       
    }
}
