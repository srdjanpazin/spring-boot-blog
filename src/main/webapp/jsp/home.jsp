<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="head.jsp" />

<jsp:include page="nav.jsp" />
<jsp:include page="banner.jsp" />

<main>
	<div class="main">
		<div class="feed">

		    <c:choose>
                <c:when test="${not empty latestPosts}">
                    <c:forEach items="${latestPosts}" var="post">
                        <div class="feed-card">
                            <div class="card-headline">
                                <a class="card-heading" href="/posts/${post.id}">
                                    <h2>${post.title}</h2>
                                </a>
                                <div class="signature">${post.author}</div>
                            </div>
                            <a class="card-image" href="/posts/${post.id}">
                                <img src="${post.image}">
                            </a>
                            <a class="first-words" href="/posts/${post.id}">
                                <div>${post.shortContent}</div>
                            </a>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <!-- latestPosts array is empty -->
                    No posts to show
                </c:otherwise>
            </c:choose>

		</div>
	</div>
</main>

<jsp:include page="footer.jsp" />
