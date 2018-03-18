package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CommentTest {

	@Test
	public void shouldHaveContentFoo() {
		String content = "Foo";
		Comment underTest = new Comment(content);
		assertThat(underTest.getContent(), is(content));
	}

	@Test
	public void shouldHaveContentBar() {
		String content = "Bar";
		Comment underTest = new Comment(content);
		String actual = underTest.getContent();
		assertThat(actual, is(content));
	}
}
