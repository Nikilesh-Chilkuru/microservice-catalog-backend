package com.p632.catalog.service;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

/**
 * This data transfer object contains the information of a single Microservice
 * entry and specifies validation rules that are used to ensure that only valid
 * information can be saved to the used database.
 * 
 * @author Naveen Jetty
 */
@Builder
@Data
public final class MSDTO {

	@Id
	private String id;
	private String description;

	@NotEmpty
	private String title;

	@NotEmpty
	private String url;

	@Override
	public String toString() {
		return String.format("MSDTO[url=%s, description=%s, title=%s, id=%s]", this.url, this.description, this.title,
				this.id);
	}
	
	public MSDTO(String id,String description,String title, String url) {
		this.id = id;
		this.description = description;
		this.title = title;
		this.url = url;
	}

	public MSDTO() {

	}
}
