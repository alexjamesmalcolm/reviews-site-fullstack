package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
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
	
	@Test
	public void shouldHaveCommentsWithDifferentIdsNotEqual() {
		Comment firstComment = new Comment(1L);
		Comment secondComment = new Comment(2L);
		boolean check = firstComment.equals(secondComment);
		assertThat(check, is(false));
	}
	
	@Ignore // The date changes depending on where the server is located
	@Test
	public void shouldGetSimpleDate() {
		Comment underTest = new Comment("", new Date(0L), null);
		String date = underTest.getSimpleDate();
		assertThat(date, is("12/31/1969 07:00 PM"));
	}
	
	@Ignore
	@Test
	public void shouldGetSimpleDateJanuary2000() {
		Comment underTest = new Comment("", new Date(946702800000L), null);
		String date = underTest.getSimpleDate();
		assertThat(date, is("01/01/2000 12:00 AM"));
	}
}
