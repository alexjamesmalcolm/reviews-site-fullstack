package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.ui.Model;

public class Controller {
	
	@Resource
	private CategoryRepository categoryRepo;

	public void listCategories(Model model) {
		Collection<Category> categories = (Collection<Category>) categoryRepo.findAll();
		model.addAttribute("categories", categories);
	}
}
