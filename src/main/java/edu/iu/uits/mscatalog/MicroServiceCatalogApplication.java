package edu.iu.uits.mscatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Validator;
import java.util.ResourceBundle;

/**
 * @author Naveen Jetty
 */

@SpringBootApplication
public class MicroServiceCatalogApplication extends WebMvcConfigurerAdapter{
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCatalogApplication.class, args);
    }

    @Bean
    public Validator validatorFactory() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    @Autowired
    public RepositoryRestConfigurer repositoryRestValidationConfigurer(@Qualifier("validatorFactory") org.springframework.validation.Validator validator) {
        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
                validatingListener.addValidator("beforeCreate", validator);
                validatingListener.addValidator("beforeSave", validator);
            }
        };
    }

    @Bean
    @Primary
    @Autowired
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    @Autowired
    public MethodValidationPostProcessor validationPostProcessor(Validator validator) {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator);
        return postProcessor;
    }


    @Bean
    public ResourceBundle validationMessages() {
        return ResourceBundle.getBundle("ValidationMessages");
    }
}
