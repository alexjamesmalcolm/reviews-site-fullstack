package org.wecancodeit.reviewssitefullstack;

import java.util.Date;

public class Comment {

	private String content;
	private Date date;
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
