package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewSiteController {

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private TagRepository tagRepo;

	@RequestMapping("/categories")
	public String getCategories(Model model) {
		Collection<Category> categories = (Collection<Category>) categoryRepo.findAll();
		model.addAttribute("categories", categories);
		return "categories-view";
	}

	@RequestMapping("/category")
	public String getCategory(@RequestParam(value = "id", required = true) long categoryId,
			Model model) {
		Category category = categoryRepo.findOne(categoryId);
		model.addAttribute("category", category);
		return "single-category-view";
	}

	public String getReview(long reviewId, Model model) {
		Review review = reviewRepo.findOne(reviewId);
		model.addAttribute("review", review);
		return "review-view";
	}

	public String getTag(long tagId, Model model) {
		Tag tag = tagRepo.findOne(tagId);
		model.addAttribute("tag", tag);
		return "tag-view";
	}

}
