package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewSiteController.class)
public class ReviewSiteControllerMockMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private CategoryRepository categoryRepo;

	@MockBean
	private ReviewRepository reviewRepo;

	@MockBean
	private TagRepository tagRepo;
	
	@MockBean
	private CommentRepository commentRepo;

	@Mock
	Tag tag;

	@Mock
	Review review;

	@Mock
	Category category;

	long tagId = 1L;
	long reviewId = 1L;
	long categoryId = 1L;

	@Before
	public void setup() {
		when(tagRepo.findOne(tagId)).thenReturn(tag);
		when(categoryRepo.findOne(categoryId)).thenReturn(category);
		when(reviewRepo.findOne(reviewId)).thenReturn(review);
		when(review.getCategory()).thenReturn(category);
	}

	@Test
	public void shouldBeOk() throws Exception {
		mvc.perform(get("/categories")).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnSingleCategoryView() throws Exception {
		mvc.perform(get("/category/1")).andExpect(view().name(is("single-category-view")));
	}

	@Test
	public void shouldReturnTagView() throws Exception {
		mvc.perform(get("/tag/1")).andExpect(view().name(is("tag-view")));
	}

	@Test
	public void shouldReturnReviewView() throws Exception {
		mvc.perform(get("/review/1")).andExpect(view().name(is("review-view")));
	}

	@Test
	public void shouldReturnIndex() throws Exception {
		mvc.perform(get("/")).andExpect(view().name(is("index")));
	}

	@Test
	public void shouldHaveAddCommentReturnReviewView() throws Exception {
		mvc.perform(get("/add-comment?id=1&comment=foobar")).andExpect(redirectedUrl("/review/1"));
	}
}
