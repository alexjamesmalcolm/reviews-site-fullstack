package org.wecancodeit.reviewssitefullstack;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String url;
	@Lob
	private String content;
	@ManyToOne
	private Category category;
	@ManyToMany
	private Collection<Tag> tags;

	@SuppressWarnings("unused")
	private Review() {
	}

	public Review(String title, String url, String content, Category category, Tag... tags) {
		this.title = title;
		this.url = url;
		this.content = content;
		this.category = category;
		this.tags = new HashSet<>(Arrays.asList(tags));
	}

	public Review(long id, Category category) {
		this.id = id;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getContent() {
		return content;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != getClass()) {
			return false;
		}
		return obj.hashCode() == hashCode();
	}

	public long getId() {
		return id;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public Category getCategory() {
		return category;
	}

}
