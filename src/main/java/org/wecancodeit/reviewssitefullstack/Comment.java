package org.wecancodeit.reviewssitefullstack;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private long id;

	private String content;
	private Date date;
	@ManyToOne
	private Review review;

	public Comment(String content, Date date, Review review) {
		this.content = content;
		this.date = date;
		this.review = review;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	public Review getReview() {
		return review;
	}

}
