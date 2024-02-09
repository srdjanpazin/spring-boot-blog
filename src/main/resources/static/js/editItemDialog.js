const editDialog = document.querySelector('.dialog__backdrop'),
	dialogHeading = editDialog.querySelector('.form-section-heading');


function openEditDialog(mode = 'edit') {

	let innerText = (mode === 'edit') ? 'Edit ' : 'Add New ';
	innerText += domainNameToSingular[domain];

	dialogHeading.innerText = innerText;
	editDialog.style.visibility = 'visible';
}


function closeEditDialog(ev) {
	ev.preventDefault();
	editDialog.style.visibility = 'hidden';
}
