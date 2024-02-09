async function submitComment() {

	const txtArea = document.getElementById('add-comment');

	const res = await fetch('/api/comments/add', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			post_id: postId,
			user_id: userId,
			body: txtArea.value
		})
	});

	if (!res.ok) {
		console.error('Failed to add comment, server responded with status ' + res.status);
		return;
	}

	window.location.reload();
}
