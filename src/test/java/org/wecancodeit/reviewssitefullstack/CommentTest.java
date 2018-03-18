package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

public class CommentTest {

	@Test
	public void shouldHaveContentFoo() {
		String content = "Foo";
		Comment underTest = new Comment(content, new Date());
		assertThat(underTest.getContent(), is(content));
	}

	@Test
	public void shouldHaveContentBar() {
		String content = "Bar";
		Comment underTest = new Comment(content, new Date());
		String actual = underTest.getContent();
		assertThat(actual, is(content));
	}
	
	@Test
	public void shouldHaveDateTime() {
		Date date = new Date();
		Comment underTest = new Comment("", date);
		Date actual = underTest.getDate();
		assertThat(actual, is(date));
	}
}
