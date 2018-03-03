package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CategoryTest {
	
	@Mock
	Review review;
	
	@Mock
	Review anotherReview;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
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
	
	@Test
	public void shouldGetNumberOfReviewsInCategoryIsTwo() {
		Category underTest = new Category("foo", review, anotherReview);
		int actual = underTest.getReviewCount();
		assertThat(actual, is(2));
	}
}
