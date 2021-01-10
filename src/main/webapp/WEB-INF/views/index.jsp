<html>
<head>
<%@include file="./base.jsp"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/script.js"/>"></script>

</head>
<body>
	<div class="hero  ">
		<div class="container ">

			<h1 class="text-center mb-3 ml-20 pt-5">This is you'r List</h1>

			<table class="table table-dark text-center">
				<thead class="thead-dark">
					<tr>
						<th scope="col">id</th>
						<th scope="col">list</th>
						<th scope="col">Delete</th>
						<th scope="col">Update</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${allList }" var="p">
						<tr>
							<th scope="row">${p.id }</th>
							<td>${p.detailList }</td>
							<td><a href="delete/${p.id }"><i
									class="ml-2 fas fa-trash-alt text-danger"
									style="font-size: 30px"></i></a></td>

							<td><a href="update/${p.id }"><i
									class="ml-2 fas fa-edit  text-primary" style="font-size: 30px"></i></a>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="container text-center">
				<a href="add-list" class="btn btn-primary ">Add List</a>
			</div>

		</div>


	</div>
	<%--  <img class="myimg" alt="image of backg" src='<c:url value="/resources/image/photo.png"/>'>  --%>
</body>
</html>
