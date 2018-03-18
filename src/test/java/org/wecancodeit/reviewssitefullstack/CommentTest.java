package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CommentTest {
	
	@Mock
	Review review;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldHaveContentFoo() {
		String content = "Foo";
		Comment underTest = new Comment(content, new Date(), review);
		assertThat(underTest.getContent(), is(content));
	}

	@Test
	public void shouldHaveContentBar() {
		String content = "Bar";
		Comment underTest = new Comment(content, new Date(), review);
		String actual = underTest.getContent();
		assertThat(actual, is(content));
	}
	
	@Test
	public void shouldHaveDateTime() {
		Date date = new Date();
		Comment underTest = new Comment("", date, review);
		Date actual = underTest.getDate();
		assertThat(actual, is(date));
	}
	
	@Test
	public void shouldHaveReview() {
		Comment underTest = new Comment("", null, review);
		Review actual = underTest.getReview();
		assertThat(actual, is(review));
	}
	
	@Test
	public void shouldNotEqualString() {
		Comment underTest = new Comment("", new Date(), null);
		String check = "";
		@SuppressWarnings("unlikely-arg-type")
		boolean actual = underTest.equals(check);
		assertThat(actual, is(false));
	}
	
	@Test
	public void shouldGetId() {
		long inputId = 1L;
		Comment underTest = new Comment(inputId);
		long id = underTest.getId();
		boolean check = id == inputId;
		assertThat(check, is(true));
	}
	
	@Test
	public void shouldHaveHashCodeBeIdAs2() {
		Comment underTest = new Comment(2L);
		long id = underTest.getId();
		int hashCode = underTest.hashCode();
		boolean check = id == hashCode;
		assertThat(check, is(true));
	}
	
	@Test
	public void shouldHaveHashCodeBeIdAs3() {
		Comment underTest = new Comment(3L);
		long id = underTest.getId();
		int hashCode = underTest.hashCode();
		boolean check = id == hashCode;
		assertThat(check, is(true));
	}
}
