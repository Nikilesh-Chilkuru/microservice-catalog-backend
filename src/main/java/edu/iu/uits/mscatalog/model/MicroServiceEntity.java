package edu.iu.uits.mscatalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Naveen Jetty
 */

@Data
@Builder
@AllArgsConstructor
public final class MicroServiceEntity {
    @Id
    private String id;

    @NotBlank(message = "{" + ConstraintMessages.TITLE_ERROR + "}")
    @Pattern(regexp = "[\\p{Print} ]{1,50}", message = "{" + ConstraintMessages.TITLE_ERROR + "}")
    private String title;

    @NotBlank(message = "{" + ConstraintMessages.DESCRIPTION_ERROR + "}")
    @Pattern(regexp = "[\\p{Print} ]{1,250}", message = "{" + ConstraintMessages.DESCRIPTION_ERROR + "}")
    private String description;

    @URL(message = "{" + ConstraintMessages.URL_ERROR + "}")
    private String url;

    @Email(message = "{" + ConstraintMessages.EMAIL_ERROR + "}")
    private String email;

    public void update(String title, String description, String url, String email) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.email = email;
    }

    public class ConstraintMessages {

        public static final String EMAIL_ERROR = "microservice.email.error";
        public static final String TITLE_ERROR = "microservice.title.error";
        public static final String URL_ERROR = "microservice.url.error";
        public static final String DESCRIPTION_ERROR = "microservice.description.error";

        protected ConstraintMessages() {
            throw new UnsupportedOperationException("Oops! Something went wrong");
        }

    }
}

