package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
	
	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = new Category("Movies");
		category = categoryRepo.save(category);
		
		long categoryId = category.getId();
		
		category = categoryRepo.findOne(categoryId);
		assertThat(category.getId(), is(greaterThan(0L)));
	}
}