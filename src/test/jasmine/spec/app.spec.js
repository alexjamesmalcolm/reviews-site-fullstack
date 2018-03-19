"use strict";
describe("app.js", () => {
	let container, removeTagSpy;
	beforeAll(() => {
		removeTagSpy = spyOn(window, "removeTag").and.callThrough();
	});
	beforeEach(() => {
		container = document.createElement("div");
		container.classList.add("container");
		container.innerHTML = `
		<main>
			<article class="review">
				<p class="tags">
					<span class="tag">
						<a></a>
						<button class="remove-tag"></button>
					</span>
				</p>
			</article>
		</main>
		`;
		document.body.appendChild(container);
		initialize();
	});
	afterEach(() => {
		container.remove();
	});
	describe("removeTag(tag)", () => {
		let removeButton, tag;
		beforeEach(() => {
			removeButton = container.querySelector("button.remove-tag");
			tag = container.querySelector("span.tag");
		});
		it("Should be called when the remove tag button is clicked", () => {
			removeButton.click();
			expect(removeTagSpy).toHaveBeenCalledWith(tag);
		});
	});
});