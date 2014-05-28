<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link
	href="//netdna.bootstrapcdn.com/bootswatch/3.1.1/spacelab/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<br />
	<br />
	<div class="container theme-showcase">
		<img src="<c:url value="/resources/images/virago_banner.jpg" />" alt="Virago Logo"/>
		<div class="page-header">
		</div>
		<div>
			<table class="table table-hover">
				<caption><b>${title}</b></caption>
				<thead>
					<tr>
						<th>Book Id</th>
						<th>Title</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${bookList}">
						<tr>
							<td>${book.id}</td>
							<td>${book.title}</td>
							<td>${book.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
</body>
</html>
