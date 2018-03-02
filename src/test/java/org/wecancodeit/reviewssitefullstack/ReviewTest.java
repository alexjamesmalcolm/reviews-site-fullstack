package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReviewTest {
	
	private Review underTest;

	@Test
	public void shouldHaveTitleStarWars() {
		String title = "Star Wars";
		underTest = new Review(title, "face.jpg");
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}
	
	@Test
	public void shouldHaveTitleBlackPanther() {
		String title = "Black Panther";
		underTest = new Review(title, "face.jpg");
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}
	
	@Test
	public void shouldHaveUrlFaceJpg() {
		String url = "face.jpg";
		underTest = new Review("", "face.jpg");
		String actual = underTest.getUrl();
		assertThat(actual, is(url));
	}
}
