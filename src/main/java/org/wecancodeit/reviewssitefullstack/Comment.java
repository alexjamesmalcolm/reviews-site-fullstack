package org.wecancodeit.reviewssitefullstack;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private long id;
	@Lob
	private String content;
	private Date date;
	@ManyToOne
	private Review review;

	public long getId() {
		return id;
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

	@SuppressWarnings("unused")
	private Comment() {
	}

	public Comment(String content, Date date, Review review) {
		this.content = content;
		this.date = date;
		this.review = review;
	}

	public Comment(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (!obj.getClass().equals(getClass())) {
			return false;
		}
		if(obj.hashCode() != hashCode()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return (int) id;
	}

	public String getSimpleDate() {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		return format.format(getDate());
	}

}
