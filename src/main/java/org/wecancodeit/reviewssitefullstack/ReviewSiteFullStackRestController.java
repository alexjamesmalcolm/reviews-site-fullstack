package org.wecancodeit.reviewssitefullstack;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

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
	}
	
	@RequestMapping(value = "/review/{id}", method = PUT)
	public Tag addTag(@PathVariable long id, @RequestParam String tagContent) {
		Review review = reviewRepo.findOne(id);
		List<Tag> copies = tagRepo.findByNameIgnoreCase(tagContent);
		Tag tag;
		if(copies.size() > 0) {
			tag = copies.get(0);
			review.addTag(tag);
		} else {
			tag = new Tag(tagContent);
			tagRepo.save(tag);
			review.addTag(tag);
		}
		return tag;
		
	}

}
