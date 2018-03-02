package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.ui.Model;

public class Controller {

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private TagRepository tagRepo;

	public String getCategories(Model model) {
		Collection<Category> categories = (Collection<Category>) categoryRepo.findAll();
		model.addAttribute("categories", categories);
		return "categories-view";
	}

	public String getCategory(long categoryId, Model model) {
		Category category = categoryRepo.findOne(categoryId);
		model.addAttribute("category", category);
		return "single-category-view";
	}

	public void getReview(long reviewId, Model model) {
		Review review = reviewRepo.findOne(reviewId);
		model.addAttribute("review", review);
	}

	public void getTag(long tagId, Model model) {
		Tag tag = tagRepo.findOne(tagId);
		model.addAttribute("tag", tag);
	}

}
