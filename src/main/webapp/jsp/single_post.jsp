<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="head.jsp" />
<jsp:include page="nav.jsp" />

<main>
	<div class="main">
		<div class="post-headline">
			<h1 class="post-heading">${post.title}</h1>
			<span class="signature">${post.author}</span>
		</div>
		<div class="post-container">
			<div class="post-body">${post.content}</div>

			<!-- <div class="tags">
				<h3>Tags</h3>
				<c:forEach items="${tags}" var="tag">
					<span>#${tag.name}</span>
				</c:forEach>
			</div> -->

			<!-- <div class="comments-section">
				<h2>Comments</h2>
				<div class="divider"></div>

				<textarea id="add-comment" row="5" placeholder="Add a comment."></textarea>
				<button onclick="submitComment()" class="app-btn" id="add-comment-btn">Comment</button>

				<c:forEach items="${comments}" var="comment">
					<div class="comment-cmp">
						<span class="comment_uname-lbl">${comment.username}</span>
						<span class="comment_date-lbl">${comment.modifiedAt}</span>
						<p>${comment.body}</p>
					</div>
				</c:forEach>
			</div> -->
		</div>

	</div>
</main>

<script>
	// var postId = ${id};
	var userId = 2;
</script>

<script src="/js/singlePostView.js"></script>

<jsp:include page="footer.jsp" />
