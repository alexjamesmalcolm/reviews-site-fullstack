package org.wecancodeit.reviewssitefullstack;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewSiteFullStackRestController {

	@Resource
	private TagRepository tagRepo;

	@Resource
	private ReviewRepository reviewRepo;

	@RequestMapping(value = "/review/{id}", method = DELETE)
	public void removeTag(@PathVariable long id, @RequestParam long tagId) {
		Review review = reviewRepo.findOne(id);
		Tag tag = tagRepo.findOne(tagId);
		review.removeTag(tag);
		reviewRepo.save(review);
	}

	@RequestMapping(value = "/review/{id}", method = PUT)
	public Tag addTag(@PathVariable long id, @RequestParam String tagContent) {
		Review review = reviewRepo.findOne(id);
		Tag tag = tagRepo.findByNameIgnoreCase(tagContent);
		if (tag == null) {
			tag = new Tag(tagContent);
			tagRepo.save(tag);
		}
		if (!review.hasTag(tag)) {
			review.addTag(tag);
			reviewRepo.save(review);
			return tag;
		}
		return null;
	}

}
