package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CategoryTest {
	
	@Test
	public void shouldHaveCategoryNameMovie() {
		String name = "Movie";
		Category underTest = new Category(name);
		String returnedName = underTest.getName();
		assertThat(returnedName, is(name));
	}
	
	@Test
	public void shouldHaveCategoryNamedMusic() {
		String name = "Music";
		Category underTest = new Category(name);
		String actual = underTest.getName();
		assertThat(actual, is(name));
	}
}
