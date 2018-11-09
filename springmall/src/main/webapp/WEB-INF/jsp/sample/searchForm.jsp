<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample</title>
<!-- bootstrap CDN -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<!-- jquery CDN -->
</head>
<body>
	<!-- 검색 -->
	<div>
		<!-- 여기서 value값은 mapper의 쿼리문과 동일해야 한다. -->
		<form action="/sample/searchSampleListAction" method="get">
			<select name="category">
				<option value="no">NO</option>	
				<option value="id">ID</option>
			</select>
			<input type="text" name="search">
			<input type="submit" value="검색">
		</form>
	</div>
</body>
</html>