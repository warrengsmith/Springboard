<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container theme-showcase">
			<div class="page-header">
				<h1>Search Results</h1>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">${title}</h3>
				</div>
				<br />
				<datatables:table id="bookList" data="${bookList}" theme="bootstrap3" cssClass="table table-striped table-hover">
   					<datatables:column title="Id" property="id" />
   					<datatables:column title="Title" property="title" />
   					<datatables:column title="Price" property="price" />
				</datatables:table>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
