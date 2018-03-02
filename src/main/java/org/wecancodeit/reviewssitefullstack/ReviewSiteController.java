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
	public String getCategory(@RequestParam(value = "id", required = true) long categoryId, Model model) {
		Category category = categoryRepo.findOne(categoryId);
		model.addAttribute("category", category);
		return "single-category-view";
	}

	@RequestMapping("/review")
	public String getReview(@RequestParam(value = "id", required = true) long reviewId, Model model) {
		Review review = reviewRepo.findOne(reviewId);
		model.addAttribute("review", review);
		return "review-view";
	}

	@RequestMapping("/tag")
	public String getTag(@RequestParam(value = "id", required = true) long tagId, Model model) {
		Tag tag = tagRepo.findOne(tagId);
		model.addAttribute("tag", tag);
		return "tag-view";
	}

	@RequestMapping("/")
	public String getAllTables(Model model) {
		Collection<Tag> tags = (Collection<Tag>) tagRepo.findAll();
		model.addAttribute("tags", tags);
		Collection<Review> reviews = (Collection<Review>) reviewRepo.findAll();
		model.addAttribute("reviews", reviews);
		Collection<Category> categories = (Collection<Category>) categoryRepo.findAll();
		model.addAttribute("categories", categories);
		return "index";
	}

}
