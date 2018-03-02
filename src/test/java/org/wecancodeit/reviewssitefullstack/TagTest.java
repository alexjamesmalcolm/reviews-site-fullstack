package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TagTest {
	
	@Test
	public void shouldHaveNameGood() {
		String name = "Good";
		Tag underTest = new Tag(name);
		String actual = underTest.getName();
		assertThat(actual, is(name));
	}
	
	@Test
	public void shouldHaveNameBad() {
		String name = "Bad";
		Tag underTest = new Tag(name);
		String actual = underTest.getName();
		assertThat(actual, is(name));
	}
}
