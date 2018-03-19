package org.wecancodeit.reviewssitefullstack;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findByNameIgnoreCase(String name);
}
