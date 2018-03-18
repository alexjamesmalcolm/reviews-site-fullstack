package org.wecancodeit.reviewssitefullstack;

import java.util.Date;

public class Comment {

	private String content;
	private Date date;

	public Comment(String content, Date date) {
		this.content = content;
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

}
