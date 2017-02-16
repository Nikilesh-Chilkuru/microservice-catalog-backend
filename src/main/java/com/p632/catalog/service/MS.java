package com.p632.catalog.service;

import static com.p632.catalog.util.PreCondition.isTrue;
import static com.p632.catalog.util.PreCondition.isValidUrl;
import static com.p632.catalog.util.PreCondition.notEmpty;
import static com.p632.catalog.util.PreCondition.notNull;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

/**
 * @author Naveen Jetty
 */

@Data
@Builder
final class MS {

	static final int MAX_LENGTH_DESCRIPTION = 250;
	static final int MAX_LENGTH_TITLE = 50;

	@Id
	private String id;
	private String description;
	private String title;
	private String url;

	public void update(String title, String description, String url) {
		checkTitleAndDescriptionAndUrl(title, description, url);
		this.title = title;
		this.description = description;
		this.url = url;
	}

	@Override
	public String toString() {
		return String.format("MS[id=%s, description=%s, title=%s, url=%s]", this.id, this.description, this.title,
				this.url);
	}

	private void checkTitleAndDescriptionAndUrl(String title, String description, String url) {
		notNull(title, "Title cannot be null");
		notEmpty(title, "Title cannot be empty");

		notNull(description, "Description cannot be null");
		notEmpty(description, "Description cannot be empty");

		isTrue(title.length() <= MAX_LENGTH_TITLE, "Title cannot be longer than %d characters", MAX_LENGTH_TITLE);

		if (description != null) {
			isTrue(description.length() <= MAX_LENGTH_DESCRIPTION, "Description cannot be longer than %d characters",
					MAX_LENGTH_DESCRIPTION);
		}

		notNull(url, "Url cannot be null");
		notEmpty(url, "Url cannot be empty");
		isValidUrl(url, "Invalid URL Format");
	}
}
