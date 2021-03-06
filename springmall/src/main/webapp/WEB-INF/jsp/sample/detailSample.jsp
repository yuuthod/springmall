<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap CDN -->
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
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<h1>회원수정</h1>
				<c:forEach var="sample" items="${samplelist}" end="0">
					<br>
					NO :
					<input value="${ sample.sampleNo }" name="sampleNo" type="text" class="form-control mb-2" readonly>
					<div>
						ID : <input value="${ sample.sampleId }" name="sampleId" type="text" class="form-control mb-2" readonly>
						<span id="idHelper"></span>
					</div>
				</c:forEach>
				<div>
					기존 FILE
					<c:forEach var="sample" items="${samplelist}">
						<a href="/download/file/${ sample.samplefileName }.${ sample.samplefileExt }">
								${ sample.samplefileName }.${ sample.samplefileExt }
						</a><br>
					</c:forEach>
				</div>
				<br>
				<div>
					<c:forEach var="sample" items="${samplelist}" end="0">
						<a href="/sample/modyfySample?sampleNo=${ sample.sampleNo }" class="btn btn-dark">수정</a>
					</c:forEach>
					<a href="/sample/sampleList" class="btn btn-secondary">목록으로</a>
				</div>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</body>
</html>