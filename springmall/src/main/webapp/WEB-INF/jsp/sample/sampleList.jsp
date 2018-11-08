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
	<div class="container">
		<div class="row">
			<div class="col-sm-1 col-md-1 col-lg-2 col-xl-2"></div>
			<div class="col-sm-10 col-md-10 col-lg-8 col-xl-8">
				<h1>SAMPLE LIST</h1>
				<table class="table table-dark table-striped">
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
								<td><a href="/sample/modyfySample?sampleNo=${ sample.sampleNo }">UPDATE</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="/sample/addSample" class="btn btn-info" role="button">회원추가</a>
				<div class="d-flex justify-content-center mb-3">
					<!-- 페이징 -->
					<div class="p-2">
						<c:choose>
							<c:when test="${currentPage > 1}"> <!-- if -->
								<a href="/sample/sampleList?currentPage=${currentPage-1}" class="btn" role="button">이전</a>
							</c:when>
							<c:otherwise> <!-- else -->
								<a href="#" class="btn" role="button">이전</a>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="p-2">
						<!-- 각 페이지별 숫자 [begin→초기치,end→조건문] -->
						<c:forEach var="page" begin="1" end="${lastPage}">
							<a href="/sample/sampleList?currentPage=${page}" class="btn" role="button">${page}</a>
						</c:forEach>
					</div>
					<div class="p-2">
						<c:choose>
							<c:when test="${ currentPage < lastPage }"> <!-- if -->
								<a href="/sample/sampleList?currentPage=${currentPage+1}" class="btn" role="button">다음</a>					
							</c:when>
							<c:otherwise> <!-- else -->
								<a href="#" class="btn" role="button">다음</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="col-sm-1 col-md-1 col-lg-2 col-xl-2"></div>
		</div>
	</div>
</body>
</html>