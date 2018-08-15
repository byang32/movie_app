<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Programming: Movie Title</title>
<meta name="description" content="This is a JSP example that demonstratses how to output
	every movies in our Excel spreadsheets to a web page.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div id="wrapper">
	<div>
		<h1>Movie Title</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
		<div>
			<c:choose>
				<c:when test="${empty cinema}">
					<p>Sorry, search can back empty.</p>
				</c:when>
				<c:otherwise>
					<c:forEach var="movies" items="${cinema}">
					<div class="span4">
						<h2>${movies.title}</h2>
						<p id="movieInfo">Directed by ${movies.director} :
						Length ${movies.lengthInMinutes} minutes</p>
					</div>	
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@include file="includes/scripts.jsp" %>
</body>
</html>