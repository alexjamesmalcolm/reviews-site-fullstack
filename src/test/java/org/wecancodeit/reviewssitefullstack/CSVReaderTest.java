package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.wecancodeit.reviewssitefullstack.CSVReader.removeDoubleQuotes;

import org.junit.Test;

public class CSVReaderTest {
	
	@Test
	public void shouldRemoveDoubleQuotes() {
		String input = "te\"st";
		String output = removeDoubleQuotes(input);
		assertThat(output, is("test"));
	}
	
	@Test
	public void shouldRemoveDoubleQuotesBar() {
		String input = "b\"ar";
		String output = removeDoubleQuotes(input);
		assertThat(output, is("bar"));
	}
}
