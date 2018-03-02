package org.wecancodeit.reviewssitefullstack;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ControllerTest {
	
	@InjectMocks
	private Controller underTest;
	
	@Mock
	private Category category;
	
	@Mock
	private Category anotherCategory;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Review review;
	
	@Mock
	private ReviewRepository reviewRepo;

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
	public void shouldAddSingleTagToModel() {}
}
