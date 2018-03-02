package org.wecancodeit.reviewssitefullstack;

public class Review {

	private String title;
	private String url;

	public Review(String title, String url, String content) {
		this.title = title;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getContent() {
		return "Hello";
	}

}
