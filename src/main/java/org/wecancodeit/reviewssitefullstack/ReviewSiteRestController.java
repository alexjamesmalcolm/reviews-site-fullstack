package org.wecancodeit.reviewssitefullstack;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewSiteRestController {

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
		Tag tag = tagRepo.findByNameIgnoreCase(tagContent);
		return tag;
//		Review review = reviewRepo.findOne(id);
//		Tag tag = tagRepo.findByNameIgnoreCase(tagContent);
//		System.out.println("TAG:");
//		System.out.println(tag);
//		
//		if(tag == null) {
//			tag = new Tag(tagContent);
//			tagRepo.save(tag);
//		}
//		System.out.println(tag);
//		Collection<Tag> tags = review.getTags();
//		System.out.println(tags);
//		System.out.println(tags.contains(tag));
//		if(!review.getTags().contains(tag)) {
//			review.addTag(tag);
//			reviewRepo.save(review);
//		}
//		return tag;

	}

}
