async function deleteObj(object, id) {

	const res = await fetch(`/api/${object}/delete/${id}`, {
		method: 'DELETE'
	});

	if (!res.ok) {
		console.error('Failed to delete object, server responded with status ' + res.status);
		return;
	}

	window.location.reload();
}
