package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private Set<Review> reviews;

	@SuppressWarnings("unused")
	private Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}

	Tag(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}
	
	public Collection<Review> getReviews() {
		return reviews;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == getClass()) {
			System.out.println(((Tag) obj).getId() + ", " + getId());
			return ((Tag) obj).getId() == getId();
		}
		return false;
	}

}
