package org.wecancodeit.reviewssitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Category music = categoryRepo.save(new Category("Music"));
		Category movie = categoryRepo.save(new Category("Movie"));
		
		Tag techno = tagRepo.save(new Tag("Techno"));
		
		Review song = reviewRepo.save(new Review("Dota", "", "Good song", music, techno));
	}
}
