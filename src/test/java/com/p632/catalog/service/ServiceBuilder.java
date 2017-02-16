package com.p632.catalog.service;

import lombok.Builder;
import lombok.Data;

/**
 * Created by naveenjetty on 2/11/17.
 */
@Data
@Builder
class ServiceBuilder {
	private String description;
	private String id;
	private String title = "NOT_IMPORTANT";
	private String url = "http://url.extn";
}
