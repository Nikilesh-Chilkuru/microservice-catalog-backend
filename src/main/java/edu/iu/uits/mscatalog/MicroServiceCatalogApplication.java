package edu.iu.uits.mscatalog;

import edu.iu.uits.mscatalog.model.MicroServiceEntity;
import edu.iu.uits.mscatalog.repository.MicroServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * @author Naveen Jetty
 */

@SpringBootApplication
public class MicroServiceCatalogApplication extends WebMvcConfigurerAdapter implements CommandLineRunner{
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


    // Method of CommandLineRunner.... Runs once every time the application starts.
    @Autowired
    private MicroServiceRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        int catalogCount = 0;
        for (MicroServiceEntity microService: this.repository.findAll()){
            catalogCount++;
            System.out.println(microService);
        }

        // If there are not catalog items in the database, create one for this microservice
        if (catalogCount == 0){
            String localURL = "http://localhost:8080";
            MicroServiceEntity entity = MicroServiceEntity.builder().title("Micro Service Catalog")
                                                                    .description("A catalog to get the list of all available microservices")
                                                                    .url(Arrays.asList(localURL,localURL,localURL))
                                                                    .email("njetty@indiana.edu")
                                                                    .build();
            this.repository.save(entity);
            System.out.println("Created a new Microservice catalog item for current service");
            System.out.println(this.repository.findByTitle("Micro Service Catalog"));
        }
        else {
            System.out.format("Already there are %d catalog items present, nothing new created",catalogCount);
        }
    }
}
