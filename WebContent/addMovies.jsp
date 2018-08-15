<!doctype hmtl>
<html>
<head>
<title>Java Web Programming: Add Movies</title>
<meta name="description" content="JSP form that add movies to the database.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div id="wrapper">
		<div>
			<h1>Add Movie</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div id="formCenter">
		<br>
		<form action="AddMovies" method="post">
			<label for="title"><strong>Title:</strong></label>
			<input name="title"><br><br>
			
			<label for="director"><strong>Director:</strong></label>
			<input name="director"><br><br>
			
			<label for="lengthInMinutes"><strong>Minutes of Movie:</strong></label>
			<input name="lengthInMinutes"><br><br>
			
			<input type="submit" value="Add Movies">
		</form>
		</div>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
</html>