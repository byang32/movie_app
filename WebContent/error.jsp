<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype hmtl>
<html>
<head>
<title>Java Web Programming: Error</title>
<meta name="description" content="JSP that demostrates a Error response page for when a page encounters a problem.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div id="wrapper">
		<div class="container">
			<h1>Error(</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div>
			<p>Uh oh, we have a problem</p>
			<c:choose>
				<c:when test="${message != null}">
				<p>${message}</p>
				</c:when>
				<c:otherwise>
					<p>To continue, click the Back button.</p>
					
					<p><strong>Error Details</strong></p>
					<p>Type: ${pageContext.exception["class"]}</p>
					<p>Message: ${pageContext.exception.message}</p>
				</c:otherwise>
			</c:choose>
		</div>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
