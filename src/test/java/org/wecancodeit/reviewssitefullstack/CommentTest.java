package org.wecancodeit.reviewssitefullstack;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CommentTest {
	
	@Test
	public void shouldHaveContent() {
		String content = "content";
		Comment underTest = new Comment(content);
		Assert.assertThat(underTest.getContent(), Matchers.is(content));
	}
}
