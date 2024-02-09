var domainNameToSingular = {
	'posts': 'post',
	'categories': 'category',
	'tags': 'tag'
};

var currItemId = null;

const menuBtn = document.querySelector('.menu-btn'),
	mainWrapperEl = document.querySelector('.wrapper');

menuBtn.addEventListener('click', () => {
	if (document.documentElement.clientWidth >= 660)
		return;

	mainWrapperEl.classList.toggle('activeSidebar');
});
