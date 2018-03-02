package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.ui.Model;

public class Controller {
	
	@Resource
	private CategoryRepository categoryRepo;

	public void getCategories(Model model) {
		Collection<Category> categories = (Collection<Category>) categoryRepo.findAll();
		model.addAttribute("categories", categories);
	}

	public void getCategory(long categoryId, Model model) {
		Category category = categoryRepo.findOne(categoryId);
		model.addAttribute("category", category);
	}
	
	
}
