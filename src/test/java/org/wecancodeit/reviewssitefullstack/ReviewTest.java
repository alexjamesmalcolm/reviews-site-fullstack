package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ReviewTest {
	
	@Test
	public void shouldHaveTitleStarWars() {
		String title = "Star Wars";
		Review underTest = new Review(title);
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}
	
	@Test
	public void shouldHaveTitleBlackPanther() {
		String title = "Black Panther";
		Review underTest = new Review(title);
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}
}
