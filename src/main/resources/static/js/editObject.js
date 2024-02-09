var author_id = 1;


async function saveChanges(ev) {

	ev.preventDefault();

	const formData = new FormData(document.forms['admin-form']);
	const data = Object.fromEntries(formData);

	data.author = { id: author_id };
	data.tags = data.tags ? [ { id: data.tags } ] : null;
	data.category = data.category ? { id: data.category } : null;

	const url = currItemId ? `/api/${domain}/${currItemId}` : `/api/${domain}`;

	let res = await fetch(url, {
		method: currItemId ? 'PUT' : 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	});

	if (!res.ok) {
		console.error('Failed to save changes, server responded with status ' + res.status);
		return;
	}

	window.location.href = `/admin/${domain}`;
}


async function selectPostTags(postId) {

	document.getElementById('tags').value = data[0].tag_id;
}
