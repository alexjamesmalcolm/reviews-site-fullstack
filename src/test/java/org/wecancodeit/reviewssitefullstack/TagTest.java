package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TagTest {

	private Tag underTest;

	@Test
	public void shouldHaveNameGood() {
		String name = "Good";
		underTest = new Tag(name);
		String actual = underTest.getName();
		assertThat(actual, is(name));
	}

	@Test
	public void shouldHaveNameBad() {
		String name = "Bad";
		underTest = new Tag(name);
		String actual = underTest.getName();
		assertThat(actual, is(name));
	}

	@Test
	public void shouldHaveOtherClassNotEqual() {
		underTest = new Tag("");
		String other = new String();
		@SuppressWarnings("unlikely-arg-type")
		boolean actual = underTest.equals(other);
		assertThat(actual, is(false));
	}
	
	@Test
	public void shouldHaveTwoSameIdsBeEqual() {
		Tag first = new Tag(1L);
		Tag second = new Tag(1L);
		boolean actual = first.equals(second);
		assertThat(actual, is(true));
	}
}
