<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

	/* 검색창 */
	.search{
		display: inline-block;
		height: 30px;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	
	/* 회원가입 버튼 */
	.listaddbtn {
		float: right;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	
	/* 페이징 버튼 */
	.paging a{
		color: #000;
	}
</style>
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
			<div class="col-sm-1 col-xl-1"></div>
			<div class="col-sm-10 col-xl-10">
				<h1 class="title">SAMPLE LIST</h1>
				<!-- 검색 -->
				<div class="search">
					<form action="/sample/sampleList" method="get">
						<select name="category">
							<option value="">==선택==</option>
							<option value="no">NO</option>
							<option value="id">ID</option>
							<option value="fileName">파일이름</option>
							<option value="fileExt">파일유형</option>
						</select> <input type="text" name="search"> <input type="submit" value="검색">
					</form>
				</div>
				<a href="/sample/addSample" class="btn btn-dark listaddbtn" role="button">회원추가</a>

				<table class="table table-dark table-striped">
					<thead>
						<tr>
							<td>SAMPLE NO</td>
							<td>SAMPLE ID</td>
							<td>SAMPLE FILE</td>
							<td>UPLOAD DATE</td>
							<td>DELETE</td>
							<td>UPDATE</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sample" items="${sampleList}">
							<tr>
								<td>${ sample.sampleNo }</td>
								<td>${ sample.sampleId }</td>
								<td>${ sample.samplefilePath }<span>\</span>${ sample.samplefileName }<span>.</span>${ sample.samplefileExt }</td>
								<td>${ sample.samplefileDate }</td>
								<td><a href="/sample/removeSample?sampleNo=${ sample.sampleNo }">DELETE</a></td>
								<td><a href="/sample/modyfySample?sampleNo=${ sample.sampleNo }">UPDATE</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 페이징 -->
				<div class="d-flex justify-content-center mb-3 paging">
					<div class="p-2">
						<c:choose>
							<c:when test="${currentPage > 1}">
								<!-- if -->
								<a href="/sample/sampleList?currentPage=${currentPage-1}" class="btn" role="button">이전</a>
							</c:when>
							<c:otherwise>
								<!-- else -->
								<a href="#" class="btn" role="button">이전</a>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="p-2">
						<!-- 	검색 후 페이지 값을 유지하기 위해 choose문사용	 -->
						<!--	각 페이지별 숫자 [begin→초기치,end→조건문]	 -->
						<c:choose>
							<c:when test="${not empty category}">
								<c:forEach var="page" begin="1" end="${lastPage}">
									<a href="/sample/sampleList?category=${category}&search=${search}&currentPage=${page}" class="btn" role="button">${page}</a>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="page" begin="1" end="${lastPage}">
									<a href="/sample/sampleList?currentPage=${page}" class="btn" role="button">${page}</a>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="p-2">
						<c:choose>
							<c:when test="${ currentPage < lastPage }">
								<!-- if -->
								<a href="/sample/sampleList?currentPage=${currentPage+1}" class="btn" role="button">다음</a>
							</c:when>
							<c:otherwise>
								<!-- else -->
								<a href="#" class="btn" role="button">다음</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="col-sm-1 col-xl-1"></div>
		</div>
	</div>
</body>
</html>