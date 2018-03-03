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
		Tag blackRepresentation = tagRepo.save(new Tag("Black Representation"));
		Tag marvel = tagRepo.save(new Tag("Marvel"));
		Tag superhero = tagRepo.save(new Tag("Superhero"));
		
		Review dota = reviewRepo.save(new Review("Dota", "", "Good song", music, techno));
		Review blackPanther = reviewRepo.save(new Review("Black Panther", "", "This is a review of black panther", movie, blackRepresentation, marvel, superhero));
	}
}
