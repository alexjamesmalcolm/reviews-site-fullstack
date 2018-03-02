package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReviewTest {

	private Review underTest;

	@Mock
	private Review review;

	@Mock
	private Review anotherReview;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldHaveTitleStarWars() {
		String title = "Star Wars";
		underTest = new Review(title, "face.jpg", "Hello", new Category(""));
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}

	@Test
	public void shouldHaveTitleBlackPanther() {
		String title = "Black Panther";
		underTest = new Review(title, "face.jpg", "Hello", new Category(""));
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}

	@Test
	public void shouldHaveUrlFaceJpg() {
		String url = "face.jpg";
		underTest = new Review("", url, "Hello", new Category(""));
		String actual = underTest.getUrl();
		assertThat(actual, is(url));
	}

	@Test
	public void shouldHaveUrlBodyJpg() {
		String url = "body.jpg";
		underTest = new Review("", url, "Hello", new Category(""));
		String actual = underTest.getUrl();
		assertThat(actual, is(url));
	}

	@Test
	public void shouldHaveContentHello() {
		String content = "Hello";
		underTest = new Review("", "", content, new Category(""));
		String actual = underTest.getContent();
		assertThat(actual, is(content));
	}

	@Test
	public void shouldHaveContentWorld() {
		String content = "World";
		underTest = new Review("", "", content, new Category(""));
		String actual = underTest.getContent();
		assertThat(actual, is(content));
	}

	@Test
	public void shouldHaveOtherClassNotEqualReview() {
		underTest = new Review("", "", "", null);
		String other = new String();
		boolean actual = underTest.equals(other);
		assertThat(actual, is(false));
	}

	@Test
	public void shouldHaveTwoDifferentIdReviewsBeNotEqual() {
		when(review.getId()).thenReturn(1L);
		when(anotherReview.getId()).thenReturn(2L);
		boolean actual = review.equals(anotherReview);
		assertThat(actual, is(false));
	}
}
