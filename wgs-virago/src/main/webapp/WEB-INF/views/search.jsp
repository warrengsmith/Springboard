<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container theme-showcase">
			<div class="page-header">
				<h1>
					Book Search&nbsp;<small>find the book you need</small>
				</h1>
			</div>
			<div class="well bs-component">
				<form:form class="form-horizontal" modelAttribute="book"
					method="post">
					<fieldset>
						<div class="form-group">
							<label for="title" class="col-lg-2 control-label">Search
								Phrase</label>
							<div class="col-lg-10">
								<form:input type="text" class="form-control" id="title"
									path="title" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2">
								<button type="submit" class="btn btn-primary">Submit</button>
								<button type="reset" class="btn btn-default">Reset</button>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
			<br /> <br />
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>