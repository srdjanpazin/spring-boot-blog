const popoverMenu = document.querySelector('.popover'),
	ellipsisButtons = document.getElementsByClassName('ellipsis-menu'),
	adminForm = document.forms['admin-form'];

Array.from(ellipsisButtons).forEach(el => el.addEventListener('click', openPopoverMenu));

window.addEventListener('click', () => {

	if (currItemId) {
		popoverMenu.style.visibility = 'hidden';
		currItemId = null;

		Array.from(document.querySelectorAll('[data-active]'))
			.forEach(el => el.removeAttribute('data-active'));
	}
});


function openPopoverMenu(ev) {

	if (this.hasAttribute('data-active')) {

		popoverMenu.style.visibility = 'hidden';
		currItemId = null;
		this.removeAttribute('data-active');

		ev.stopPropagation();
		return;
	}

	const domRect = this.getBoundingClientRect(),
		popoverWidth = popoverMenu.getBoundingClientRect().width;

	popoverMenu.style.top = domRect.bottom + window.scrollY + 'px';
	popoverMenu.style.left = domRect.right + window.scrollX - popoverWidth + 'px';

	popoverMenu.style.visibility = 'visible';
	currItemId = this.dataset.itemId;

	this.setAttribute('data-active', '');
	ev.stopPropagation();
}


function goToEditPost() {
	window.location.assign(`/admin/posts/${currItemId}/edit`);
}


function goToViewPage() {
	window.location.assign(`/posts/${currItemId}`);
}


async function deleteItem() {

	const res = await fetch(`/api/${domain}/${currItemId}`, {
		method: 'DELETE'
	});

	if (!res.ok) {
		console.error(`Failed to delete ${domainNameToSingular[domain]}, server responded with status ${res.status}`);
		return;
	}

	window.location.reload();
}
