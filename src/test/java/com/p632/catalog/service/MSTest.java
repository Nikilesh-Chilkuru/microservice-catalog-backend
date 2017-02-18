package com.p632.catalog.service;

import static com.p632.catalog.service.ServiceAssert.assertThatService;

import org.junit.Test;

/**
 * Created by naveenjetty on 2/11/17.
 */
public class MSTest {
	private static final String DESCRIPTION = "description";
	private static final String TITLE = "title";
	private static final String URL = "http://naveenjetty.com";

	private static final int MAX_LENGTH_DESCRIPTION = 250;
	private static final int MAX_LENGTH_TITLE = 50;

	private static final String UPDATED_DESCRIPTION = "updatedDescription";
	private static final String UPDATED_TITLE = "updatedTitle";
	private static final String UPDATE_URL = "https://naveenjetty.com";

	private static final String INVALID_URL = "randomStringNotInUrlFormat";

//	@Test(expected = NullPointerException.class)
//	public void build_TitleIsNull_ShouldThrowException() {
//		MS.builder().title(null).description(DESCRIPTION).url(URL).build();
//	}

//	@Test(expected = IllegalArgumentException.class)
//	public void build_TitleIsEmpty_ShouldThrowException() {
//		MS.builder().title("").description(DESCRIPTION).url(URL).build();
//	}

//	@Test(expected = IllegalArgumentException.class)
//	public void build_TitleIsTooLong_ShouldThrowException() {
//		String tooLongTitle = StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE + 1);
//		MS.builder().title(tooLongTitle).description(DESCRIPTION).url(URL).build();
//	}

//	@Test(expected = NullPointerException.class)
//	public void build_DescriptionIsNull_ShouldThrowException() {
//		MS.builder().title(TITLE).description(null).url(URL).build();
//	}

//	@Test(expected = IllegalArgumentException.class)
//	public void build_DescriptionIsEmpty_ShouldThrowException() {
//		MS.builder().title(TITLE).description("").url(URL).build();
//	}

//	@Test(expected = IllegalArgumentException.class)
//	public void build_DescriptionIsTooLong_ShouldThrowException() {
//		String tooLongDescription = StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION + 1);
//		MS.builder().title(TITLE).description(tooLongDescription).url(URL).build();
//	}

//	@Test(expected = IllegalArgumentException.class)
//	public void build_UrlIsInvalid_shouldThrowException() {
//		MS.builder().title(TITLE).description(DESCRIPTION).url(INVALID_URL).build();
//	}

//	@Test
//	public void build_WithTitleAndDescriptionAndUrl_ShouldCreateServiceEntryWithCorrectTitleAndDescriptionAndUrl() {
//		MS build = MS.builder().title(TITLE).description(DESCRIPTION).url(URL).build();
//
//		assertThatService(build).hasNoId().hasTitle(TITLE).hasDescription(DESCRIPTION).hasUrl(URL);
//	}
}