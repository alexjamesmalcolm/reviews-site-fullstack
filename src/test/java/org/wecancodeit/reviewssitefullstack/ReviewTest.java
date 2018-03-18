package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReviewTest {
	
	@Mock
	private Category category;

	private Review underTest;
	
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
		@SuppressWarnings("unlikely-arg-type")
		boolean actual = underTest.equals(other);
		assertThat(actual, is(false));
	}

	@Test
	public void shouldHaveTwoDifferentIdReviewsBeNotEqual() {
		Review review = new Review(1L, null);
		Review anotherReview = new Review(2L, null);
		boolean actual = review.equals(anotherReview);
		assertThat(actual, is(false));
	}

	@Test
	public void shouldHaveTwoSameIdReviewsBeEqual() {
		Review review = new Review(1L, null);
		Review anotherReview = new Review(1L, null);
		boolean actual = review.equals(anotherReview);
		assertThat(actual, is(true));
	}
	
	@Test
	public void shouldGetCategory() {
		Review review = new Review(1L, category);
		Category actual = review.getCategory();
		assertThat(actual, is(category));
	}
}
