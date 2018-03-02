package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
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
	
	@Test
	public void shouldBeOk() throws Exception {
		mvc.perform(get("/categories")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnSingleCategoryView() throws Exception {
		mvc.perform(get("/category?id=1")).andExpect(view().name(is("single-category-view")));
	}
	
	@Test
	public void shouldReturnTagView() throws Exception {
		mvc.perform(get("/tag?id=1")).andExpect(view().name(is("tag-view")));
	}
	
	@Test
	public void shouldReturnReviewView() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review-view")));
	}
	
	@Test
	public void shouldReturnIndex() throws Exception {
		mvc.perform(get("/")).andExpect(view().name(is("index")));
	}
}
