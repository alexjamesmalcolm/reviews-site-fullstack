package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CommentRepository commentRepo;

	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = new Category("Movies");
		category = categoryRepo.save(category);

		long categoryId = category.getId();

		category = categoryRepo.findOne(categoryId);
		assertThat(category.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadTag() {
		Tag tag = new Tag("");
		tag = tagRepo.save(tag);

		long tagId = tag.getId();

		tag = tagRepo.findOne(tagId);
		assertThat(tag.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveReviewToCategoryRelationship() {
		Category category = new Category("Movies");
		categoryRepo.save(category);
		long categoryId = category.getId();

		Review first = new Review("", "", "", category);
		reviewRepo.save(first);

		Review second = new Review("", "", "", category);
		reviewRepo.save(second);

		entityManager.flush();
		entityManager.clear();

		category = categoryRepo.findOne(categoryId);
		assertThat(category.getReviews(), containsInAnyOrder(first, second));
	}

	@Test
	public void shouldSaveReviewToTagRelationship() {
		Tag tag = new Tag("");
		tagRepo.save(tag);
		long tagId = tag.getId();

		Review first = new Review("", "", "", null, tag);
		reviewRepo.save(first);

		Review second = new Review("", "", "", null, tag);
		reviewRepo.save(second);

		entityManager.flush();
		entityManager.clear();

		tag = tagRepo.findOne(tagId);
		assertThat(tag.getReviews(), containsInAnyOrder(first, second));
	}

	@Test
	public void shouldSaveTagToReviewRelationship() {
		Tag first = new Tag("");
		tagRepo.save(first);
		Tag second = new Tag("");
		tagRepo.save(second);

		Review review = new Review("", "", "", null, first, second);
		reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getTags(), containsInAnyOrder(first, second));
	}

	@Test
	public void shouldSaveCommentToReviewRelationship() {
		Review review = new Review("", "", "", null);
		reviewRepo.save(review);
		long reviewId = review.getId();
		
		Comment comment = new Comment("", new Date(), review);
		commentRepo.save(comment);
		
		Comment anotherComment = new Comment("", new Date(), review);
		commentRepo.save(anotherComment);
		
		entityManager.flush();
		entityManager.clear();
		
		review = reviewRepo.findOne(reviewId);
		assertThat(review.getComments(), containsInAnyOrder(comment, anotherComment));
	}
}
