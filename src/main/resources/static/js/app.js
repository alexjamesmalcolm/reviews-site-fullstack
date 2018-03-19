function initialize() {
	const container = document.body.querySelector("div.container");
	const tags = container.querySelectorAll("span.tag");
	const reviewId = container.querySelector("form.add-tag button").value;
	tags.forEach(tag => {
		const button = tag.querySelector("button.remove-tag");
		button.addEventListener("click", () => {
			removeTag(reviewId, tag);
		});
	});
	const addTagForm = container.querySelector("form.add-tag");
	addTagForm.addEventListener("submit", (event) => {
		event.preventDefault();
		const content = addTagForm.querySelector("input").value;
		const pTags = container.querySelector("p.tags");
		addTag(reviewId, content, pTags);
		addTagForm.querySelector("input").value = "";
	});
}

function removeTag(id, tag) {
	const tagId = tag.querySelector("button").value;
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if (xhr.readyState == 4 && xhr.status == 200) {
			tag.remove();
		}
	};
	const location = `/review/${id}?tagId=${tagId}`;
	xhr.open("DELETE", location, true);
	xhr.send();
}

function addTag(id, content, tags) {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if (xhr.readyState == 4 && xhr.status == 200) {
			const response = JSON.parse(xhr.responseText);
			console.log(response);
			const tag = document.createElement("span");
			tag.classList.add("tag");
			tag.innerHTML = `
			<a href="/tag/${response.id}">${response.name}</a>
			<button class="remove-tag">X</button>
			`;
			tags.appendChild(tag);
		}
	};
	const location = `/review/${id}?tagContent=${content}`;
	xhr.open("PUT", location, true);
	xhr.send();
}