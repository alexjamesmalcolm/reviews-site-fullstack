package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReviewTest {
	
	private Review underTest;

	@Test
	public void shouldHaveTitleStarWars() {
		String title = "Star Wars";
		underTest = new Review(title, "face.jpg", "Hello");
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}
	
	@Test
	public void shouldHaveTitleBlackPanther() {
		String title = "Black Panther";
		underTest = new Review(title, "face.jpg", "Hello");
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}
	
	@Test
	public void shouldHaveUrlFaceJpg() {
		String url = "face.jpg";
		underTest = new Review("", url, "Hello");
		String actual = underTest.getUrl();
		assertThat(actual, is(url));
	}
	
	@Test
	public void shouldHaveUrlBodyJpg() {
		String url = "body.jpg";
		underTest = new Review("", url, "Hello");
		String actual = underTest.getUrl();
		assertThat(actual, is(url));
	}
	
	@Test
	public void shouldHaveContentHello() {
		String content = "Hello";
		underTest = new Review("", "", content);
		String actual = underTest.getContent();
		assertThat(actual, is(content));
	}
	
	@Test
	public void shouldHaveContentWorld() {
		String content = "World";
		underTest = new Review("", "", content);
		String actual = underTest.getContent();
		assertThat(actual, is(content));
	}
}
