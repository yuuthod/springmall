<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample</title>
<!-- bootstrap CDN -->
<!-- jquery CDN -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>sample</h1>
	<table class="table">
		<thead>
			<tr>
				<td>SAMPLE NO</td>
				<td>SAMPLE ID</td>
				<td>SAMPLE PW</td>
				<td>DELETE</td>
				<td>UPDATE</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sample" items="${sampleList}">
				<tr>
					<td>${ sample.sampleNo }</td>
					<td>${ sample.sampleId }</td>
					<td>${ sample.samplePw }</td>
					<td><a href="/sample/removeSample?sampleNo=${ sample.sampleNo }">DELETE</a></td>
					<td><a href="/sample/updateSample?sampleNo=${ sample.sampleNo }">UPDATE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>