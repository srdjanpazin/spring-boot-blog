var author_id = "1";

async function loadDataIntoForm(object, objId) {

	const res = await fetch(`/api/${object}/${objId}`);

	if (!res.ok) {
		console.error('Failed to load post data, server responded with status ' + res.status);
		return;
	}

	const { data } = await res.json();

	const form = document.forms['admin-form'];

	Object.keys(data).forEach(key => {
		let formControl = form.querySelector(`#${key}`);
		
		if (formControl)
			formControl.value = data[key];
	});
}


async function saveChanges(ev, object, objId = null) {

	ev.preventDefault();

	const formData = new FormData(document.forms['admin-form']);
	const data = Object.fromEntries(formData);

	if (object === 'posts')
		data.author_id = author_id;

	const url = objId ? `/api/${object}/edit/${objId}` : `/api/${object}/add`;

	let res = await fetch(url, {
		method: objId ? 'PUT' : 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	});

	if (!res.ok) {
		console.error('Failed to save changes, server responded with status ' + res.status);
		return;
	}

	window.location.href = `/admin/${object}`;
}


async function selectPostTags(postId) {

	const res = await fetch(`/api/posts/${postId}/tags`);

	if (!res.ok) {
		console.error('Failed to load post data, server responded with status ' + res.status);
		return;
	}

	const { data } = await res.json();

	document.getElementById('tags').value = data[0].tag_id;
}
