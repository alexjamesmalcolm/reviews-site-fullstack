function initialize() {
	const container = document.body.querySelector("div.container");
	const tags = document.querySelectorAll("span.tag");
	tags.forEach(tag => {
		const button = tag.querySelector("button.remove-tag");
		button.addEventListener("click", () => {
			removeTag(tag);
		});
	});
}

function removeTag() {}