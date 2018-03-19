package org.wecancodeit.reviewssitefullstack;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ReviewSiteControllerTest {

	@InjectMocks
	private ReviewSiteController underTest;

	@Mock
	private Category category;

	@Mock
	private Category anotherCategory;

	@Mock
	private CategoryRepository categoryRepo;

	@Mock
	private Review review;
	
	@Mock
	private Review anotherReview;

	@Mock
	private ReviewRepository reviewRepo;

	@Mock
	private Tag tag;
	
	@Mock
	private Tag anotherTag;

	@Mock
	private TagRepository tagRepo;

	@Mock
	private Model model;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddCategoriesToModel() {
		Collection<Category> allCategories = asList(category, anotherCategory);
		when(categoryRepo.findAll()).thenReturn(allCategories);

		underTest.getCategories(model);

		verify(model).addAttribute("categories", allCategories);
	}

	@Test
	public void shouldAddSingleCategoryToModel() {
		long categoryId = 1L;
		when(category.getId()).thenReturn(categoryId);
		when(categoryRepo.findOne(categoryId)).thenReturn(category);

		underTest.getCategory(categoryId, model);

		verify(model).addAttribute("category", category);
	}

	@Test
	public void shouldAddSingleReviewToModel() {
		long reviewId = 1L;
		when(review.getId()).thenReturn(reviewId);
		when(reviewRepo.findOne(reviewId)).thenReturn(review);

		underTest.getReview(reviewId, model);

		verify(model).addAttribute("review", review);
	}

	@Test
	public void shouldAddSingleTagToModel() {
		long tagId = 1L;
		when(tag.getId()).thenReturn(tagId);
		when(tagRepo.findOne(tagId)).thenReturn(tag);

		underTest.getTag(tagId, model);

		verify(model).addAttribute("tag", tag);
	}
	
	@Test
	public void shouldAddReviewAndCategoriesToModel() {
		Collection<Review> allReviews = asList(review, anotherReview);
		Collection<Category> allCategories = asList(category, anotherCategory);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		when(categoryRepo.findAll()).thenReturn(allCategories);
		
		underTest.getAllTables(model);
		
		verify(model).addAttribute("reviews", allReviews);
		verify(model).addAttribute("categories", allCategories);
	}
	
	@Test
	public void shouldHaveGetAllTablesReturnIndex() {
		String templateName = underTest.getAllTables(model);
		assertThat(templateName, is("index"));
	}
	
	@Test
	public void shouldHaveGetCategoriesReturnCategoriesView() {
		String templateName = underTest.getCategories(model);
		assertThat(templateName, is("categories-view"));
	}
	
	@Test
	public void shouldHaveGetCategoryReturnSingleCategoryView() {
		String templateName = underTest.getCategory(0L, model);
		assertThat(templateName, is("single-category-view"));
	}
	
	@Test
	public void shouldHaveGetReviewReturnReviewView() {
		String templateName = underTest.getReview(0L, model);
		assertThat(templateName, is("review-view"));
	}
	
	@Test
	public void shouldHaveGetTagReturnTagView() {
		String templateName = underTest.getTag(0L, model);
		assertThat(templateName, is("tag-view"));
	}
	
	@Test
	public void shouldHaveAddCommentRedirectToGetReview1L() {
		String templateName = underTest.addComment(1L, model);
		assertThat(templateName, is("redirect:/review/1"));
	}
	
	@Test
	public void shouldHaveAddCommentRedirectToGetReview2L() {
		String templateName = underTest.addComment(2L, model);
		assertThat(templateName, is("redirect:/review/2"));
	}
}
