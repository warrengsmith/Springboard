<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion"%>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container theme-showcase">
			<div class="page-header">
				<h1>Search Results</h1>
			</div>
			<br />
			<datatables:table id="bookList" data="${bookList}" theme="jqueryui" themeOption="smoothness"
				cssClass="table hover table-striped table-bordered table-condensed table-curved table-hover">
				<datatables:column title="Id" property="id" />
				<datatables:column title="Title" property="title" />
				<datatables:column title="Price" property="price" />
			</datatables:table>
			<br />
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
