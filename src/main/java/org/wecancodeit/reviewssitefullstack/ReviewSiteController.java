package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/category/{id}")
	public String getCategory(@PathVariable long id, Model model) {
		Category category = categoryRepo.findOne(id);
		model.addAttribute("category", category);
		return "single-category-view";
	}

	@RequestMapping("/review/{id}")
	public String getReview(@PathVariable long id, Model model) {
		Review review = reviewRepo.findOne(id);
		model.addAttribute("review", review);
		return "review-view";
	}

	@RequestMapping("/tag/{id}")
	public String getTag(@PathVariable long id, Model model) {
		Tag tag = tagRepo.findOne(id);
		model.addAttribute("tag", tag);
		return "tag-view";
	}

	@RequestMapping("/")
	public String getAllTables(Model model) {
		Collection<Review> reviews = (Collection<Review>) reviewRepo.findAll();
		model.addAttribute("reviews", reviews);
		Collection<Category> categories = (Collection<Category>) categoryRepo.findAll();
		model.addAttribute("categories", categories);
		return "index";
	}

}
