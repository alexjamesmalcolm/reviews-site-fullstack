package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReviewSiteRestControllerTest {

	@InjectMocks
	private ReviewSiteRestController underTest;
	
	@Mock
	private Tag tag;
	
	@Mock
	private TagRepository tagRepo;
	
	@Mock
	private Review review;
	
	@Mock
	private ReviewRepository reviewRepo;

	private long reviewId;

	private String tagContent;

	private long tagId;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		reviewId = 1L;
		when(review.getId()).thenReturn(reviewId);
		when(reviewRepo.findOne(reviewId)).thenReturn(review);
		tagContent = "tag";
		when(tag.getName()).thenReturn(tagContent);
		tagId = 1L;
		when(tag.getId()).thenReturn(tagId);
		when(tagRepo.findByNameIgnoreCase(tagContent)).thenReturn(tag);
	}
	
	@Test
	public void shouldHaveAddCommentReturnOldComment() {
		Tag result = underTest.addTag(reviewId, tagContent);
		assertThat(result.getId(), is(tagId));
	}
	
	
}
