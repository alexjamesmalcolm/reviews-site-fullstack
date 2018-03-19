package org.wecancodeit.reviewssitefullstack;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private Set<Tag> tags;
	@OneToMany(mappedBy = "review")
	private List<Comment> comments;

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
	
	public List<Comment> getComments() {
		return comments;
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}

	public boolean hasTag(Tag tag) {
		return getTags().contains(tag);
	}

}
