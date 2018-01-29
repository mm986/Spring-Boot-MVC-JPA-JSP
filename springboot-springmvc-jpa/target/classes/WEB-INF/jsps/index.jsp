<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>Spring-Boot-MVC-JPA-JSP</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Spring-MVC-Test</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">All Books</a></li>
      <li><a href="new">New Book</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
	<h1 align="center"><span class="label label-default">Course Management</span></h1>
	<c:choose>
		<c:when test="${mode=='VIEW'}">
			<span class="label label-danger">${ERROR}</span>
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Course ID</th>
			        <th>Course Name</th>
			        <th>Description</th>
			        <th>Topic ID</th>
			        <th>Edit</th>
			        <th>Delete</th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach var="course" items="${courses}">
			      		<tr>
			      				<td>${course.id}</td>
			      				<td>${course.name}</td>
			      				<td>${course.description}</td>
			      				<td>${course.topicId}</td>
			      				<td><a href="edit?id=${course.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
			      				<td><a href="delete?id=${course.id}"><div class="glyphicon glyphicon-trash"></div></a></td>
			      		</tr>
			      </c:forEach>
			    </tbody>
			  </table>
		</c:when>
		<c:when test="${mode=='EDIT' || mode=='NEW'}">
			<c:if test="${mode=='EDIT' }"><h2><span class="label label-default">Edit Course</span></h2> </c:if>
			<c:if test="${mode=='NEW' }"><h2><span class="label label-default">Add Course</span></h2></c:if>
			<span class="label label-danger">${ERROR}</span>
			<form action="save" method="POST">
			  <div class="form-group">
			    <!--  <label for="id">Course ID</label> 
			    <input type="hidden" class="form-control" value="${course.id}" id="id" name="id"> -->
			    
			    <label for="id">Course ID</label>
			    <input type="text" class="form-control" value="${course.id}" id="id" name="id">
			  </div>
			  <div class="form-group">
			    <label for="name">Course Name</label>
			    <input type="text" class="form-control" value="${course.name}" id="name" name="name">
			  </div>
			  <div class="form-group">
			    <label for="description">Description</label>
			    <input type="text" class="form-control" value="${course.description}" id="description" name="description">
			  </div>
			   <div class="form-group">
			    <label for="topicId">Topic ID</label>
			    <input type="text" class="form-control" value="${course.topicId}" id="topicId" name="topicId">
			  </div>
			  <button type="submit" class="btn btn-default">Submit <div class="glyphicon glyphicon-pencil"></div></button>
			</form>
		</c:when>
	</c:choose>

 
</div>

</body>
</html>
