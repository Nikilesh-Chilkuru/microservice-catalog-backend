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

import cz.jirutka.validator.collection.constraints.EachPattern;
import cz.jirutka.validator.collection.constraints.EachURL;

import java.util.List;

/**
 * @author Naveen Jetty
 *
 */

@Data
@Builder
@AllArgsConstructor
public final class MicroServiceEntity {
    @Id
    private String id;

    @NotBlank(message = "{" + ConstraintMessages.TITLE_BLANK + "}")
    @Pattern(regexp = "[\\p{Print} ]{1,50}", message = "{" + ConstraintMessages.TITLE_ERROR + "}")
    private String title;

    @NotBlank(message = "{" + ConstraintMessages.DESCRIPTION_BLANK + "}")
    @Pattern(regexp = "[\\p{Print} ]{1,250}", message = "{" + ConstraintMessages.DESCRIPTION_ERROR + "}")
    private String description;

    //@URL(message = "{" + ConstraintMessages.URL_ERROR + "}")
    //@EachPattern(regexp = ConstraintMessages.URL_REGEX, message = "{" + ConstraintMessages.URL_BLANK + "}")
    //private String url;

    @NotNull(message = "{" + ConstraintMessages.URL_BLANK + "}")
    @EachURL(message = "{" + ConstraintMessages.URL_ERROR + "}")
    List<String> url;

    @NotBlank(message = "{" + ConstraintMessages.EMAIL_BLANK + "}")
    @Email(message = "{" + ConstraintMessages.EMAIL_ERROR + "}")
    private String email;

    public void update(String title, String description, List<String> url, String email) {
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

        public static final String TITLE_BLANK = "microservice.title.blank";
        public static final String DESCRIPTION_BLANK = "microservice.description.blank";
        public static final String EMAIL_BLANK = "microservice.email.blank";
        public static final String URL_BLANK = "microservice.url.blank";

        //public static final String URL_REGEX = "(?:[A-Za-z][A-Za-z0-9+.-]*:\\/{2})?(?:(?:[A-Za-z0-9-._~]|%[A-Fa-f0-9]{2})+(?::([A-Za-z0-9-._~]?|[%][A-Fa-f0-9]{2})+)?@)?(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\\\.){1,126}[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?(?::[0-9]+)?(?:\\/(?:[A-Za-z0-9-._~]|%[A-Fa-f0-9]{2})*)*(?:\\\\?(?:[A-Za-z0-9-._~]+(?:=(?:[A-Za-z0-9-._~+]|%[A-Fa-f0-9]{2})+)?)(?:&|;[A-Za-z0-9-._~]+(?:=(?:[A-Za-z0-9-._~+]|%[A-Fa-f0-9]{2})+)?)*)?\n"


        protected ConstraintMessages() {
            throw new UnsupportedOperationException("Oops! Something went wrong");
        }

    }
}

