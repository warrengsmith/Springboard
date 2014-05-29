<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
	<div class="container theme-showcase">
		<div class="page-header">
			<h1>Search Results</h1>
		</div>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">${title}</h3>
			</div>
			<br />
			<table class="table table-striped table-hover">
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
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>
