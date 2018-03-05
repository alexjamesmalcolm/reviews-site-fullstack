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
		Category alexsIdeas = categoryRepo.save(new Category("Alex's Ideas"));

		Tag techno = tagRepo.save(new Tag("Techno"));
		Tag blackRepresentation = tagRepo.save(new Tag("Black Representation"));
		Tag marvel = tagRepo.save(new Tag("Marvel"));
		Tag superhero = tagRepo.save(new Tag("Superhero"));
		Tag overPromiseUnderDeliver = tagRepo.save(new Tag("Over Promise Under Deliver"));
		Tag good = tagRepo.save(new Tag("Good"));
		Tag bad = tagRepo.save(new Tag("Bad"));

		Review dota = reviewRepo.save(new Review("Dota", "dota.jpg", "Good song: 7/10", music, techno, good));
		Review blackPanther = reviewRepo.save(new Review("Black Panther", "black-panther.jpg",
				"This is a review of black panther: 10/10", movie, blackRepresentation, marvel, superhero, good));
		Review importingAmazonReviews = reviewRepo.save(
				new Review("Importing Amazon Reviews from data.world into the ReviewPopulator", "stressedman.jpeg",
						"Couldn't get it to work before Monday 0/10.", alexsIdeas, overPromiseUnderDeliver, bad));
		Review usingThyemleafsReplace = reviewRepo
				.save(new Review("Using Thymeleaf's replace attribute so I don't have to code as much", "thymeleaf.png",
						"10/10 easily one of my laziest ideas ever", alexsIdeas, good));
		Review dannyLeavingChipsOnMyCouch = reviewRepo.save(new Review(
				"Danny spilling chips on my couch and then noticing and not cleaning them up even though he admitted to spilling them",
				"dorito.jpg", "Not that good, probably wouldn't watch again", movie, bad));
	}
}
