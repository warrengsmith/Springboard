<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion"%>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables"%>
<dandelion:bundle includes="bootstrap3" />
<dandelion:asset cssExcludes="datatables" />
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<div class="container theme-showcase">
		<div class="page-header">
			<h1>Search Results</h1>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Search for all books</h3>
			</div>
			<br />
			<datatables:table id="bookList" data="${bookList}" theme="bootstrap3" cssClass="table table-striped table-hover">
				<datatables:column title="Id" property="id" />
				<datatables:column title="Title" property="title" />
				<datatables:column title="Price" property="price" />
			</datatables:table>
		</div>
	</div>
</body>
</html>
