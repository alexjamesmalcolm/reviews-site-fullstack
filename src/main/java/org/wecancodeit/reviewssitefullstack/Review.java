package org.wecancodeit.reviewssitefullstack;

public class Review {

	private String title;
	private String url;
	private String content;

	public Review(String title, String url, String content) {
		this.title = title;
		this.url = url;
		this.content = content;
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

}
