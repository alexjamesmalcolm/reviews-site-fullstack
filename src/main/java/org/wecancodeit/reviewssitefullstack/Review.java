package org.wecancodeit.reviewssitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String url;
	private String content;
	@ManyToOne
	private Category category;
	
	@SuppressWarnings("unused")
	private Review() {}

	public Review(String title, String url, String content, Category category) {
		this.title = title;
		this.url = url;
		this.content = content;
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
	public boolean equals(Object obj) {
		Review other = (Review) obj;
		return other.title == title;
	}

}
