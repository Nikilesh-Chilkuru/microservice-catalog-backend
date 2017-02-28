package edu.iu.uits.mscatalog.dto;

import lombok.*;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;

import edu.iu.uits.mscatalog.model.MicroServiceEntity.ConstraintMessages;

/**
 * This data transfer object contains the information of a single Microservice
 * entry and specifies validation rules that are used to ensure that only valid
 * information can be saved to the used database.
 *
 * @author Naveen Jetty
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public final class MicroServiceEntityDTO {

    @Id
    private String id;

    @NotBlank(message = "{" + ConstraintMessages.DESCRIPTION_ERROR + "}")
    @Pattern(regexp = "[\\p{Print} ]{1,250}", message = "{" + ConstraintMessages.DESCRIPTION_ERROR + "}")
    private String description;

    @NotBlank(message = "{" + ConstraintMessages.TITLE_ERROR + "}")
    @Pattern(regexp = "[\\p{Print} ]{1,50}", message = "{" + ConstraintMessages.TITLE_ERROR + "}")
    private String title;

    @URL(message = "{" + ConstraintMessages.URL_ERROR + "}")
    private String url;

    @Email(message = "{" + ConstraintMessages.EMAIL_ERROR + "}")
    private String email;

}